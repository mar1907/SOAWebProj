package com.ds.entity.dto;

import com.ds.entity.Package;

public class PackageDTO {

    private int id;
    private String name;
    private String description;
    private String senderCity;
    private String destCity;
    private int tracking;
    private int senderId;
    private int receiverId;

    public PackageDTO(Package pack) {
        id = pack.getId();
        name = pack.getName();
        description = pack.getDescription();
        senderCity = pack.getSenderCity();
        destCity = pack.getDestCity();
        tracking = pack.getTracking();
        senderId = pack.getSender().getId();
        receiverId = pack.getReceiver().getId();
    }

    public PackageDTO() {
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

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverID) {
        this.receiverId = receiverID;
    }
}
