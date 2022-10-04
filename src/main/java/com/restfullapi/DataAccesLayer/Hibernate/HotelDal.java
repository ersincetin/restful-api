package com.restfullapi.DataAccesLayer.Hibernate;

import com.restfullapi.DataAccesLayer.ICrudDal;
import com.restfullapi.Entities.Hotel;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class HotelDal implements ICrudDal {
    private EntityManager entityManager;
    private Session session;

    @Autowired
    public HotelDal(EntityManager entityManager) {
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
        Hotel hotel = session.get(Hotel.class, index);
    }

    @Override
    @Transactional
    public Object getById(int index) {
        Hotel hotel = session.get(Hotel.class, index);
        return hotel;
    }

    @Transactional
    public List<Hotel> getAll() {
        List<Hotel> hotelList = session.createQuery("from Hotel").getResultList();
        return hotelList;
    }
}
