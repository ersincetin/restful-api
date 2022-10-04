package com.restfullapi.Business;

import com.restfullapi.DataAccesLayer.Hibernate.UserDal;
import com.restfullapi.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserManager implements ICrudService {
    private UserDal userDal;

    @Autowired
    public UserManager(UserDal userDal) {
        this.userDal = userDal;
    }

    @Override
    @Transactional
    public void create(Object object) {
        this.userDal.create(object);
    }

    @Override
    @Transactional
    public void update(Object object) {
        this.userDal.update(object);
    }

    @Override
    @Transactional
    public void delete(int index) {
        this.userDal.delete(index);
    }

    @Override
    @Transactional
    public Object getById(int index) {
        return this.userDal.getById(index);
    }

    public List<User> getAll() {
        return this.userDal.getAll();
    }
}
