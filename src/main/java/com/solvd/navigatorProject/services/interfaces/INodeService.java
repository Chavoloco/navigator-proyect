package com.solvd.navigatorProject.services.interfaces;

import com.solvd.navigatorProject.binary.Node;

import java.util.List;

public interface INodeService {

    void save(Node node);

    Node getById(long id);

    void delete(long id);

    List<Node> getAll();

    Node findFist();

    Node findLast();
}
