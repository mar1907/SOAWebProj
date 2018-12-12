package com.ds.entity.dto;

import com.ds.entity.PackageTracking;

import java.util.Date;

public class PackageTrackingDTO {

    private int id;
    private String city;
    private Date moment;
    private int packId;

    public PackageTrackingDTO() {
    }

    public PackageTrackingDTO(PackageTracking packageTracking) {
        id = packageTracking.getId();
        city = packageTracking.getCity();
        moment = packageTracking.getMoment();
        packId = packageTracking.getPack().getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public int getPackId() {
        return packId;
    }

    public void setPackId(int packId) {
        this.packId = packId;
    }
}
