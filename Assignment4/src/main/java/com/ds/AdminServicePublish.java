package com.ds;

import com.ds.service.AdminServiceImpl;

import javax.xml.ws.Endpoint;

public class AdminServicePublish {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8079/adminservice",
                new AdminServiceImpl());
    }

}
