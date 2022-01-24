package com.solvd.navigatorProyect.dao.interfaces;

import java.util.List;

public interface IEntityDao <T>{
    void save(T t);

    T getById(long Id);

    void delete(T t);

    List<T> getAll();
}
