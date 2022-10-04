package com.restfullapi.DataAccesLayer;

public interface ICrudDal {
    void create(Object object);

    void update(Object object);

    void delete(int index);

    Object getById(int index);
}
