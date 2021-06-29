package com.example.projectinsight.helpers;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.projectinsight.R;
import com.example.projectinsight.models.ProductModel;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.text.DecimalFormat;
import java.util.List;

public class ListProductAdapter extends ArrayAdapter<ProductModel> {

    private Context context;
    ViewHolderItem holderChild;

    public ListProductAdapter(Context context, List<ProductModel> listGroup) {
        super(context, R.layout.listproduct_header, listGroup);
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //View listViewItem = inflater.inflate(R.layout.barchart_item, null, true);
        if (view == null) {
            view = inflater.inflate(R.layout.listproduct_header, null);
            holderChild = new ViewHolderItem();

            holderChild.txtDuration = view.findViewById(R.id.txtDuration);
            holderChild.txtTitle = view.findViewById(R.id.txtTitle);
            holderChild.ImageIcon = view.findViewById(R.id.ImageIcon);
            holderChild.txtValue = view.findViewById(R.id.txtValue);
            holderChild.txtId = view.findViewById(R.id.txtId);

            holderChild.txtDisponivel = view.findViewById(R.id.txtDisponivel);
            holderChild.chartDisponivel = view.findViewById(R.id.chartDisponivel);

            holderChild.txtSold = view.findViewById(R.id.txtSold);
            holderChild.chartSold = view.findViewById(R.id.chartSold);

            holderChild.txtTotalViews = view.findViewById(R.id.txtTotalViews);
            holderChild.txtTotalComment = view.findViewById(R.id.txtTotalComment);

            holderChild.grid3Group = view.findViewById(R.id.grid3Group);

            holderChild.ChipAnuncioTipo = view.findViewById(R.id.ChipAnuncioTipo);
            holderChild.ChipAnuncioStatus = view.findViewById(R.id.ChipAnuncioStatus);
            holderChild.ChipSomenteGarantia = view.findViewById(R.id.ChipSomenteGarantia);
            holderChild.ChipAnuncioFrete = view.findViewById(R.id.ChipAnuncioFrete);

            holderChild.grid1 = view.findViewById(R.id.grid1);

            holderChild.grid3Group.setFocusable(false);
            holderChild.ChipAnuncioTipo.setFocusable(false);
            holderChild.ChipAnuncioStatus.setFocusable(false);
            holderChild.ChipSomenteGarantia.setFocusable(false);
            holderChild.ChipAnuncioFrete.setFocusable(false);

            view.setTag(holderChild);
        } else {
            holderChild = (ViewHolderItem) view.getTag();
        }

        ProductModel item = getItem(position);
        //String data = DateFormat.format("yyyy-MM-dd", item.getDATETIME()).toString();
        DecimalFormat formatter = new DecimalFormat("###,###");
        String value = formatter.format((Integer) item.getPrice());

        holderChild.txtTitle.setText(item.getTitle());
        holderChild.txtValue.setText("R$ " + value);
        holderChild.ImageIcon.setImageBitmap(item.getThumbnail());

        holderChild.txtId.setText(item.getId());
        holderChild.txtDisponivel.setText(String.valueOf(item.getAvailableQuantity()) + " disponíveis");
        holderChild.txtSold.setText(String.valueOf(item.getSoldQuantity()) + " vendas");

        holderChild.txtTotalViews.setText(String.valueOf(item.getTotalView()));
        holderChild.txtTotalComment.setText(String.valueOf(item.getTotalComments()));

        Float chartWidth = view.getResources().getDimension(R.dimen.chartSolddimens);
        int TotalVendas = (item.getAvailableQuantity() + item.getSoldQuantity());
        Float WidthToTotal = (chartWidth / TotalVendas);
        holderChild.chartSold.getLayoutParams().width = (int) (WidthToTotal * item.getSoldQuantity());

        holderChild.ChipAnuncioTipo.setText(item.getAnuncioTipo());
        holderChild.ChipAnuncioStatus.setText(item.getAnuncioStatus());
        holderChild.ChipSomenteGarantia.setText(item.getSomenteGarantia());
        holderChild.ChipAnuncioFrete.setText(item.getAnuncioFrete());

        //Log.i("FirstFragment", ("chartWidth: " + chartWidth));
        //Log.i("FirstFragment", ("TotalVendas: " + TotalVendas));
        //Log.i("FirstFragment", ("WidthToTotal: " + WidthToTotal));
        //holderChild.chartDisponivel
        //holderChild.chartSold
        //Log.i("FirstFragment", ("holderChild.chartDisponivel: " + holderChild.grid1.getWidth()));

        return view;
    }

    private class ViewHolderItem {
        TextView txtDuration;
        TextView txtTitle;
        ImageView ImageIcon;
        TextView txtValue;
        TextView txtId;

        TextView txtDisponivel;
        View chartDisponivel;

        TextView txtSold;
        View chartSold;
        LinearLayout grid1;

        TextView txtTotalViews;
        TextView txtTotalComment;
        ChipGroup grid3Group;

        Chip ChipAnuncioTipo;
        Chip ChipAnuncioStatus;
        Chip ChipSomenteGarantia;
        Chip ChipAnuncioFrete;
    }
}
