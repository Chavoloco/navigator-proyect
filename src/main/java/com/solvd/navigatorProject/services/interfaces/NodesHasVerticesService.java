package com.solvd.navigatorProject.services.interfaces;

import com.solvd.navigatorProject.binary.Node;
import com.solvd.navigatorProject.binary.Vertex;

import java.util.List;

public interface NodesHasVerticesService {

    void joinNodes(Node nodeA, Vertex vertex, Node nodeB);

    void joinNodes(Node nodeA, Vertex vertex);
}
