package com.example.projectinsight.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MetricModel {

    @SerializedName("item_id")
    @Expose
    private String itemId;
    @SerializedName("date_from")
    @Expose
    private String dateFrom;
    @SerializedName("date_to")
    @Expose
    private String dateTo;
    @SerializedName("total_visits")
    @Expose
    private Integer totalVisits;
    @SerializedName("visits_detail")
    @Expose
    private VisitModel visitsDetail;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public Integer getTotalVisits() {
        return totalVisits;
    }

    public void setTotalVisits(Integer totalVisits) {
        this.totalVisits = totalVisits;
    }

    public VisitModel getVisitsDetail() {
        return visitsDetail;
    }

    public void setVisitsDetail(VisitModel visitsDetail) {
        this.visitsDetail = visitsDetail;
    }
}
