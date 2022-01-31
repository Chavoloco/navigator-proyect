package com.solvd.navigatorProject.services.interfaces;

import com.solvd.navigatorProject.binary.Node;
import com.solvd.navigatorProject.binary.Vertex;

import java.util.List;

public interface IVertexService {
    void save(Vertex vertex);

    Vertex getById(long id);

    void delete(Vertex vertex);

    List<Vertex> getAll();
}
