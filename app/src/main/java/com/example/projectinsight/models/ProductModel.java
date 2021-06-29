package com.example.projectinsight.models;

import android.graphics.Bitmap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductModel {

    //  BODY
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("thumbnail")
    @Expose
    private Bitmap thumbnail;

    @SerializedName("total_view")
    @Expose
    private int TotalView;
    @SerializedName("total_comments")
    @Expose
    private int TotalComments;

    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("available_quantity")
    @Expose
    private int availableQuantity;
    @SerializedName("sold_quantity")
    @Expose
    private int soldQuantity;

    //  ADS TYPE
    @SerializedName("anuncio_tipo")
    @Expose
    private String AnuncioTipo;
    @SerializedName("anuncio_status")
    @Expose
    private String AnuncioStatus;
    @SerializedName("somente_garantia")
    @Expose
    private String SomenteGarantia;
    @SerializedName("anuncio_frete")
    @Expose
    private String AnuncioFrete;

    @SerializedName("DATA")
    @Expose
    private List<DataItemModel> DATA = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public Bitmap getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Bitmap thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getTotalView() {
        return TotalView;
    }

    public void setTotalView(int totalView) {
        TotalView = totalView;
    }

    public int getTotalComments() {
        return TotalComments;
    }

    public void setTotalComments(int totalComments) {
        TotalComments = totalComments;
    }

    public String getAnuncioTipo() {
        return AnuncioTipo;
    }

    public void setAnuncioTipo(String anuncioTipo) {
        AnuncioTipo = anuncioTipo;
    }

    public String getAnuncioStatus() {
        return AnuncioStatus;
    }

    public void setAnuncioStatus(String anuncioStatus) {
        AnuncioStatus = anuncioStatus;
    }

    public String getSomenteGarantia() {
        return SomenteGarantia;
    }

    public void setSomenteGarantia(String somenteGarantia) {
        SomenteGarantia = somenteGarantia;
    }

    public String getAnuncioFrete() {
        return AnuncioFrete;
    }

    public void setAnuncioFrete(String anuncioFrete) {
        AnuncioFrete = anuncioFrete;
    }

    public List<DataItemModel> getDATA() {
        return DATA;
    }

    public void setDATA(List<DataItemModel> DATA) {
        this.DATA = DATA;
    }
}
