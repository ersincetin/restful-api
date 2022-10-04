package com.restfullapi.DataAccesLayer.Hibernate;

import com.restfullapi.DataAccesLayer.ICrudDal;
import com.restfullapi.Entities.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDal implements ICrudDal {
    private EntityManager entityManager;
    private Session session;

    @Autowired
    public UserDal(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.session = entityManager.unwrap(Session.class);
    }

    @Override
    @Transactional
    public void create(Object object) {
        this.session.save(object);
    }

    @Override
    @Transactional
    public void update(Object object) {
        this.session.update(object);
    }

    @Override
    @Transactional
    public void delete(int index) {
        User user = session.get(User.class, index);
        this.session.delete(user);
    }

    @Override
    @Transactional
    public Object getById(int index) {
        User user = session.get(User.class, index);
        return user;
    }

    @Transactional
    public List<User> getAll() {
        List<User> userList = session.createQuery("from User").getResultList();
        return userList;
    }
}
