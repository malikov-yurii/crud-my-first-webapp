package com.malikov.dao;

import com.malikov.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.service.spi.SessionFactoryServiceInitiator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        logger.info("User successfully saved/added. User details: " + user);
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("User successfully updated. User details: " + user);
    }

    @Override
    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        if (user!=null){
            session.delete(user);
        }
        logger.info("User successfully removed. User details: " + user);
    }

    @Override
    public User getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        logger.info("User successfully loaded. User details: " + user);
        return user;
    }

    @Override
    @SuppressWarnings("uncheched")
    public List<User> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").list();
        for (User user: userList){
            logger.info("User list: " + user);
        }
        return userList;
    }

//    this is my method to get user from database by name
//    I think it is ok. But dont know for sure
    @Override
    @SuppressWarnings("uncheched")
    public User getUserByName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where name =:name ");
        query.setParameter("name", name);
        User user = (User) query.uniqueResult();
        logger.info("User list: " + user);
        return user;
    }
}