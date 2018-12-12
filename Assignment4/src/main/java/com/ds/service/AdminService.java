package com.ds.service;

import com.ds.entity.Package;
import com.ds.entity.User;
import com.ds.entity.dto.PackageDTO;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.Date;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface AdminService {

    @WebMethod
    String addPackage(Package pack, int senderId, int receiverId);

    @WebMethod
    String deletePackage(int id);

    @WebMethod
    String registerPackage(int id);

    @WebMethod
    String updateTracking(int id, String city, Date date);

    @WebMethod
    PackageDTO[] getPackages();

    @WebMethod
    User[] getUsers();

}
