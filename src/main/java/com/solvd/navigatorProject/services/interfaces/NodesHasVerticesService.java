package com.solvd.navigatorProject.services.interfaces;

import com.solvd.navigatorProject.binary.NodeHasVertices;
import com.solvd.navigatorProject.binary.Vertex;

import java.util.List;

public interface NodesHasVerticesService {

    void joinNodes(NodeHasVertices nhs);

    List<Vertex> getVerticesByNodeId(long id);

    void deleteAllJoinedNodes();

}
