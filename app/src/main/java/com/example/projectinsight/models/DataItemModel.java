package com.example.projectinsight.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class DataItemModel {

    @SerializedName("DATETIME")
    @Expose
    private Date DATETIME;

    @SerializedName("QTD")
    @Expose
    private long QTD;

    public DataItemModel(Date DATETIME, long QTD) {
        this.DATETIME = DATETIME;
        this.QTD = QTD;
    }

    public DataItemModel(DataItemModel data) {
        this.DATETIME = data.DATETIME;
        this.QTD = data.QTD;
    }

    /* GETTER & SETTER */

    public Date getDATETIME() {
        return DATETIME;
    }

    public void setDATETIME(Date DATETIME) {
        this.DATETIME = DATETIME;
    }

    public long getQTD() {
        return QTD;
    }

    public void setQTD(long QTD) {
        this.QTD = QTD;
    }
}
