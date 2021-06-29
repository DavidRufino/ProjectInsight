package com.example.projectinsight.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VisitModel {
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
