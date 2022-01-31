package com.solvd.navigatorProject.dao.interfaces;

import java.util.List;

public interface IEntityDao <T>{
    void save(T t);

    T getById(long id);

    void delete(long id);

    List<T> getAll();
}
