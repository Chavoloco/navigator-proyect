package com.solvd.navigatorProject.services.interfaces;

import com.solvd.navigatorProject.binary.Node;
import com.solvd.navigatorProject.binary.Vertex;

import java.util.List;

public interface IVertexService {

    void save(Vertex vertex);

    Vertex getById(long id);

    void delete(long id);

    List<Vertex> getAll();

    double getDistanceById(long id);

    void setDestination(Node node);

    void setSource(Node node);

    Vertex findFirst();

    Vertex findLast();

}
