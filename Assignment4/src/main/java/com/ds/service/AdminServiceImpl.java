package com.ds.service;

import com.ds.dao.PackageDAO;
import com.ds.dao.PackageTrackingDAO;
import com.ds.dao.UserDAO;
import com.ds.entity.Package;
import com.ds.entity.PackageTracking;
import com.ds.entity.User;
import com.ds.entity.dto.PackageDTO;
import com.ds.entity.utils.Notification;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebService(endpointInterface = "com.ds.service.AdminService")
public class AdminServiceImpl implements AdminService{

    private PackageDAO packageDAO;

    private PackageTrackingDAO packageTrackingDAO;

    private UserDAO userDAO;


    public AdminServiceImpl() {
        this.packageDAO = new PackageDAO();
        this.userDAO = new UserDAO();
        this.packageTrackingDAO = new PackageTrackingDAO();
    }

    public AdminServiceImpl(PackageDAO packageDAO, PackageTrackingDAO packageTrackingDAO, UserDAO userDAO) {
        this.packageDAO = packageDAO;
        this.packageTrackingDAO = packageTrackingDAO;
        this.userDAO = userDAO;
    }

    @WebMethod
    public String addPackage(Package pack, int senderId, int receiverId){
        Notification<Boolean> notification = new Notification<>();

        pack.setSender(userDAO.getUser(senderId));
        pack.setReceiver(userDAO.getUser(receiverId));

        Package result = packageDAO.addPackage(pack);

        if(result == null){
            notification.addError("Could not add package.");
            notification.setResult(false);
        } else {
            notification.setResult(true);
        }

        return notification.getFormattedErrors();
    }

    @WebMethod
    public String deletePackage(int id){
        Notification<Boolean> notification = new Notification<>();

        if(packageDAO.deletePackage(id)==null){
            notification.addError("No such package");
            notification.setResult(false);
        } else {
            notification.setResult(true);
        }

        return notification.getFormattedErrors();
    }

    @WebMethod
    public String registerPackage(int id){
        Notification<Boolean> notification = new Notification<>();

        Package pack = packageDAO.findPackage(id);
        if(pack==null){
            notification.addError("No such package");
            notification.setResult(false);
            return notification.getFormattedErrors();
        }

        pack.setTracking(1);

        pack = packageDAO.updatePackage(pack);

        if(pack==null){
            notification.addError("No such package");
            notification.setResult(false);
            return notification.getFormattedErrors();
        }

        PackageTracking packageTracking = new PackageTracking(pack.getSenderCity(), new Date(), pack);

        packageTracking = packageTrackingDAO.addPackageTracking(packageTracking);

        if(packageTracking==null){
            notification.addError("Could not add package tracking");
            notification.setResult(false);
        } else {
            notification.setResult(true);
        }

        return notification.getFormattedErrors();
    }

    @WebMethod
    public String updateTracking(int id, String city, Date date){
        Notification<Boolean> notification = new Notification<>();

        Package pack = packageDAO.findPackage(id);

        if(pack==null){
            notification.addError("No such package");
            notification.setResult(false);
            return notification.getFormattedErrors();
        }

        PackageTracking packageTracking = new PackageTracking(city, date, pack);

        packageTracking = packageTrackingDAO.addPackageTracking(packageTracking);

        if(packageTracking==null){
            notification.addError("Could not add package tracking");
            notification.setResult(false);
        } else {
            notification.setResult(true);
        }

        return notification.getFormattedErrors();
    }

    @WebMethod
    public PackageDTO[] getPackages(){
        List<Package> list = packageDAO.getPackages();

        List<PackageDTO> result = new ArrayList<>();

        for(Package p: list){
            result.add(new PackageDTO(p));
        }

        return result.toArray(new PackageDTO[0]);
    }

    @WebMethod
    public User[] getUsers(){
        ArrayList<User> list = userDAO.getUsers();
        return list.toArray(new User[0]);
    }

}
