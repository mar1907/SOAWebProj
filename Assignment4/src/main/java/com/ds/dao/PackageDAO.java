package com.ds.dao;

import com.ds.entity.Package;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class PackageDAO {

    private SessionFactory factory;

    public PackageDAO() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public PackageDAO(SessionFactory factory) {
        this.factory = factory;
    }

    public List<Package> getPackages(){
        Session session = factory.openSession();
        Transaction tx = null;
        List<Package> packages = new ArrayList<>();
        try {
            tx = session.beginTransaction();
            packages = session.createQuery("FROM Package").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }

        return packages;
    }

    public Package findPackage(int id) {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Package> packages = new ArrayList<>();
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Package WHERE id = :id");
            query.setParameter("id", id);
            packages = query.list();
            tx.commit();
            for(Package pack: packages){
                Hibernate.initialize(pack.getSender());
                Hibernate.initialize(pack.getReceiver());
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

    public Package addPackage(Package pack){
        int packageId = -1;
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            packageId = (Integer) session.save(pack);
            pack.setId(packageId);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null){
                tx.rollback();
            }
        } finally {
            session.close();
        }

        return pack;
    }

    public Package updatePackage(Package pack){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(pack);
            tx.commit();
        } catch (HibernateException e){
            if(tx != null){
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return pack;
    }

    public Package deletePackage(int id){
        Session session = factory.openSession();
        Transaction tx = null;
        Package pack = findPackage(id);
        if(pack == null) return null;
        try {
            tx = session.beginTransaction();
            session.delete(pack);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return pack;
    }
}
