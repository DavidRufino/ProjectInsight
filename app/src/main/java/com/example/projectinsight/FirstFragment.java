package com.example.projectinsight;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.projectinsight.helpers.ListProductAdapter;
import com.example.projectinsight.models.ProductModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class FirstFragment extends Fragment {

    ListProductAdapter listProductAdapter;
    private List<ProductModel> listSource;
    private ListView ListProduct;
    private Button btnGenProduct;

    public String REQ_TAG_EDITITEM = "REQ_TAG_EDITITEM";

    //  CONTEM O NOME DO PRODUTO
    private String[] TitleArray = {
            "Samsung Galaxy M21s",
            "Aspirador De Pó",
            "Ar Condicionado Split",
            "Samsung Series 7",
            "Jogo De Panelas",
            "Fritadeira Elétrica",
            "Parafusadeira A Bateria",
            "Máquina de lavar automática",
            "Torradeira E Cafeteira",
            "Microondas Electrolux",
            "Sanduicheira + Prensa Grill"
    };

    //  CONTEM INFORMACAO DO PRODUTO
    private String[] LastTitleArray = {
            "Por Favor Sem Ofertar",
            "Remover peças",
            "Promoção",
            "Imperdivel",
            "Novo",
            "Leia Descrição",
            "Com problemas",
            "branca 12kg 127 V",
            "Kit Cadence Colors Amarelo",
            "branco 20L 127V",
            "Mr Cheff"
    };

    //  IMAGEM DO PRODUTO
    private String[] ImageProduct = {
            "D_Q_NP_923654-MLA44557641284_012021-C.jpg",
            "D_Q_NP_878556-MLA43247865566_082020-C.jpg",
            "D_Q_NP_683895-MLB44856287383_022021-C.jpg",
            "D_Q_NP_648789-MLA43006489595_082020-C.jpg",
            "D_Q_NP_812691-MLB42123122562_062020-C.jpg",
            "D_Q_NP_907647-MLA32623426205_102019-C.jpg",
            "D_Q_NP_865067-MLB32941266571_112019-C.jpg",
            "D_NQ_NP_778036-MLA32541321352_102019-O.webp",
            "D_NQ_NP_681997-MLB41138572823_032020-O.webp",
            "D_NQ_NP_764908-MLA31454797775_072019-O.webp",
            "D_NQ_NP_786550-MLB42195219526_062020-O.webp"
    };

    //  TIPO DO ANUNCIO
    private String[] AdType = {
            "Anuncio Clássico",
            "Anuncio Premium",
            "Usado",
            "Novo",
            "Sem Garantia",
            "Com Garantia",
            "Com frete grátis",
            "Não oferecer frete grátis"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_first, container, false);

        if (listSource == null) listSource = new ArrayList<>();

        btnGenProduct = root.findViewById(R.id.btnGenProduct); // Added at 2021-04-01
        ListProduct = root.findViewById(R.id.listproduct); // Added at 2021-04-01

        listProductAdapter = new ListProductAdapter(getActivity(), listSource);
        ListProduct.setDivider(null);
        ListProduct.setAdapter(listProductAdapter);
        ListProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("FirstFragment", ("ListProduct: onItemClick"));
            }
        });

        btnGenProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listSource.add(onGenerateProduct());    //  GENERATE PRODUCT
                listProductAdapter.notifyDataSetChanged();

                ListProduct.smoothScrollByOffset(listProductAdapter.getCount());
            }
        });
        return root;
    }

    private ProductModel onGenerateProduct() {
        ProductModel item = new ProductModel();

        Long uniqueId = System.currentTimeMillis() / 100;
        String Idgenerator = ("#" + uniqueId);

        Random r = new Random();
        int min = 263;
        int max = 4253;

        Integer[] intArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> intList = Arrays.asList(intArray);

        Collections.shuffle(intList);   //  shuffle Array
        String Title = TitleArray[intArray[0]];
        String Thumbnail = ImageProduct[intArray[0]];

        Collections.shuffle(intList);   //  shuffle Array
        String LastTitle = LastTitleArray[intArray[0]];

        String title = String.format("%1$s - %2$s", Title, LastTitle);

        //  Ads type
        String AnuncioTipo = getAdType(1);
        String AnuncioStatus = getAdType(2);
        String SomenteGarantia = getAdType(3);
        String AnuncioFrete = getAdType(4);

        //  Adding to Obejct
        item.setId(Idgenerator);
        item.setTitle(title);
        item.setThumbnail(getImageFromAsset(Thumbnail));

        item.setPrice(r.nextInt(max - min) + min);

        item.setAvailableQuantity(r.nextInt(max - 0) + 0);
        item.setSoldQuantity(r.nextInt(Math.abs(item.getAvailableQuantity() - min)) + min);

        item.setTotalView(r.nextInt(max - min + 1) + min);
        item.setTotalComments(r.nextInt(item.getTotalView() - min) + min);

        //  Ads type
        item.setAnuncioTipo(AnuncioTipo);
        item.setAnuncioStatus(AnuncioStatus);
        item.setSomenteGarantia(SomenteGarantia);
        item.setAnuncioFrete(AnuncioFrete);

        Log.i("onGenerateProduct", ("Id: " + Idgenerator));
        Log.i("onGenerateProduct", ("Title: " + title));
        Log.i("onGenerateProduct", ("Thumbnail: " + Thumbnail));
        Log.i("onGenerateProduct", ("getPrice: " + item.getPrice()));
        Log.i("onGenerateProduct", ("getAvailableQuantity: " + item.getAvailableQuantity()));
        Log.i("onGenerateProduct", ("getSoldQuantity: " + item.getSoldQuantity()));
        Log.i("onGenerateProduct", ("getTotalView: " + item.getTotalView()));
        Log.i("onGenerateProduct", ("getTotalComments: " + item.getTotalComments()));

        Log.i("onGenerateProduct", ("getAnuncioTipo: " + item.getAnuncioTipo()));
        Log.i("onGenerateProduct", ("getAnuncioStatus: " + item.getAnuncioStatus()));
        Log.i("onGenerateProduct", ("getSomenteGarantia: " + item.getSomenteGarantia()));
        Log.i("onGenerateProduct", ("getAnuncioFrete: " + item.getAnuncioFrete()));
        return item;
    }

    //  GET AD TYPE
    private String getAdType(int type) {

        Integer[] intArray;

        switch (type) {
            case 1: //  AnuncioTipo
                intArray = new Integer[]{0, 1};
                break;
            case 2: //  AnuncioStatus
                intArray = new Integer[]{2, 3};
                break;
            case 3: //  SomenteGarantia
                intArray = new Integer[]{4, 5};
                break;
            default:    //  AnuncioFrete
                intArray = new Integer[]{6, 7};
                break;
        }

        List<Integer> intList = Arrays.asList(intArray);
        Collections.shuffle(intList);   //  shuffle Array

        return AdType[intArray[0]];
    }

    //  GET BITMAP FROM URI
    private Bitmap getImageFromAsset(String uri) {
        AssetManager assetManager = getContext().getAssets();
        InputStream istr = null;
        try {
            istr = assetManager.open(uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(istr);
        return bitmap;
    }
}