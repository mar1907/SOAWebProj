package com.ds.dao;

import com.ds.entity.Package;
import com.ds.entity.PackageTracking;
import com.ds.entity.User;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class PackageTrackingDAO {

    private SessionFactory factory;

    public PackageTrackingDAO() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public PackageTrackingDAO(SessionFactory factory) {
        this.factory = factory;
    }

    public PackageTracking addPackageTracking(PackageTracking packageTracking){
        int packageTrackingId = -1;
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            packageTrackingId = (Integer) session.save(packageTracking);
            packageTracking.setId(packageTrackingId);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null){
                tx.rollback();
            }
        } finally {
            session.close();
        }

        return packageTracking;
    }

    public PackageTracking findPackageTrackingByPackage(Package pack) {
        Session session = factory.openSession();
        Transaction tx = null;
        List<PackageTracking> packages = new ArrayList<>();
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM PackageTracking WHERE package_id = :id");
            query.setParameter("id", pack.getId());
            packages = query.list();
            tx.commit();
            for(PackageTracking packT: packages){
                Hibernate.initialize(packT.getPack());
            }
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return packages != null && !packages.isEmpty() ? packages.get(0) : null;
    }

}
