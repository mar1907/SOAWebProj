package com.ds.entity;

import java.util.Date;

public class PackageTracking {

    private int id;
    private String city;
    private Date moment;
    private Package pack;

    public PackageTracking() {
    }

    public PackageTracking(int id, String city, Date moment, Package pack) {
        this.id = id;
        this.city = city;
        this.moment = moment;
        this.pack = pack;
    }

    public PackageTracking(String city, Date moment, Package pack) {
        this.city = city;
        this.moment = moment;
        this.pack = pack;
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

    public Package getPack() {
        return pack;
    }

    public void setPack(Package pack) {
        this.pack = pack;
    }

    @Override
    public String toString() {
        return "PackageTracking{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", moment=" + moment +
                ", pack=" + pack +
                '}';
    }
}
