package com.restfullapi.Business;

public interface ICrudService {
    void create(Object object);

    void update(Object object);

    void delete(int index);

    Object getById(int index);
}
