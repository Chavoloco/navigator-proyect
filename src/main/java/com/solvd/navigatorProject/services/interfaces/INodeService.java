package com.solvd.navigatorProject.services.interfaces;

import com.solvd.navigatorProject.binary.Node;
import com.solvd.navigatorProject.binary.Vertex;

import java.util.List;

public interface INodeService {

    void save(Node node);

    Node getById(long id);

    void delete(long id);

    List<Node> getAll();

    Node findFirst();

    Node findLast();
}
