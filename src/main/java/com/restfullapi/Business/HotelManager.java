package com.restfullapi.Business;

import com.restfullapi.DataAccesLayer.Hibernate.HotelDal;
import com.restfullapi.Entities.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HotelManager implements ICrudService {
    private HotelDal hotelDal;

    @Autowired
    public HotelManager(HotelDal hotelDal) {
        this.hotelDal = hotelDal;
    }

    @Override
    @Transactional
    public void create(Object object) {
        this.hotelDal.create(object);
    }

    @Override
    @Transactional
    public void update(Object object) {
        this.hotelDal.update(object);
    }

    @Override
    @Transactional
    public void delete(int index) {
        this.hotelDal.delete(index);
    }

    @Override
    @Transactional
    public Object getById(int index) {
        return null;
    }

    @Transactional
    public List<Hotel> getAll() {
        return this.hotelDal.getAll();
    }
}
