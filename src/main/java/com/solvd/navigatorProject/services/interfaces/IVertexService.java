package com.solvd.navigatorProject.services.interfaces;

import com.solvd.navigatorProject.binary.Vertex;

import java.util.List;

public interface IVertexService {

    void save(Vertex vertex);

    Vertex getById(long id);

    void delete(long id);

    void deleteAll();

    List<Vertex> getAll();

    long getDistanceById(long id);

    Vertex findFist();

    Vertex findLast();

}
