package com.ds.entity;

public class Package {

    private int id;
    private String name;
    private String description;
    private String senderCity;
    private String destCity;
    private int tracking;
    private User sender;
    private User receiver;

    public Package() {
    }

    public Package(int id, String name, String description, String senderCity, String destCity, int tracking, User sender, User receiver) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.senderCity = senderCity;
        this.destCity = destCity;
        this.tracking = tracking;
        this.sender = sender;
        this.receiver = receiver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSenderCity() {
        return senderCity;
    }

    public void setSenderCity(String senderCity) {
        this.senderCity = senderCity;
    }

    public String getDestCity() {
        return destCity;
    }

    public void setDestCity(String destCity) {
        this.destCity = destCity;
    }

    public int getTracking() {
        return tracking;
    }

    public void setTracking(int tracking) {
        this.tracking = tracking;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", senderCity='" + senderCity + '\'' +
                ", destCity='" + destCity + '\'' +
                ", tracking=" + tracking +
                ", sender=" + sender +
                ", receiver=" + receiver +
                '}';
    }
}
