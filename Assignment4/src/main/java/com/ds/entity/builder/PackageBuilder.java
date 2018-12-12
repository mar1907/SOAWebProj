package com.ds.entity.builder;

import com.ds.entity.Package;
import com.ds.entity.User;

public class PackageBuilder {

    private Package pack;

    public PackageBuilder() {
        this.pack = new Package();
    }

    public PackageBuilder setId(int id){
        pack.setId(id);
        return this;
    }

    public PackageBuilder setName(String name){
        pack.setName(name);
        return this;
    }

    public PackageBuilder setDescription(String description){
        pack.setDescription(description);
        return this;
    }

    public PackageBuilder setSenderCity(String senderCity){
        pack.setSenderCity(senderCity);
        return this;
    }

    public PackageBuilder setDestCity(String destCity){
        pack.setDestCity(destCity);
        return this;
    }

    public PackageBuilder setTracking(int tracking){
        pack.setTracking(tracking);
        return this;
    }

    public PackageBuilder setSender(User sender){
        pack.setSender(sender);
        return this;
    }

    public PackageBuilder setReceiver(User receiver){
        pack.setReceiver(receiver);
        return this;
    }

    public Package build(){
        return pack;
    }
}
