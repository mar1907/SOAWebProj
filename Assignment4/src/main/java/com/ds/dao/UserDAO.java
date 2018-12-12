package com.ds.dao;

import com.ds.entity.User;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private SessionFactory factory;

    public UserDAO() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public UserDAO(SessionFactory factory) {
        this.factory = factory;
    }

    public User getUser(String username){
        Session session = factory.openSession();
        Transaction tx = null;
        List<User> users = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM User WHERE " +
                    "username = :username");
            query.setParameter("username", username);
            users = query.list();
            tx.commit();
        } catch (HibernateException e){
            if(tx != null){
                tx.rollback();
            }
        } finally {
            session.close();
        }

        return users != null && !users.isEmpty() ? users.get(0) : null;
    }

    public User getUser(int id){
        Session session = factory.openSession();
        Transaction tx = null;
        List<User> users = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM User WHERE " +
                    "id = :id");
            query.setParameter("id", id);
            users = query.list();
            tx.commit();
        } catch (HibernateException e){
            if(tx != null){
                tx.rollback();
            }
        } finally {
            session.close();
        }

        return users != null && !users.isEmpty() ? users.get(0) : null;
    }

    public ArrayList<User> getUsers(){
        Session session = factory.openSession();
        Transaction tx = null;
        List<User> users = new ArrayList<>();
        try {
            tx = session.beginTransaction();
            users = session.createQuery("FROM User").list();
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }

        return new ArrayList<>(users);
    }

    public User addUser(User user){
        int userId = -1;
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            userId = (Integer) session.save(user);
            user.setId(userId);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null){
                tx.rollback();
            }
        } finally {
            session.close();
        }

        return user;
    }
}