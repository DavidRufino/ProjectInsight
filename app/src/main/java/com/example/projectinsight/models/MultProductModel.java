package com.example.projectinsight.models;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class MultProductModel {

    //  HEADER
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("body")
    @Expose
    private ProductModel body;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ProductModel getBody() {
        return body;
    }

    public void setBody(ProductModel body) {
        this.body = body;
    }
}
