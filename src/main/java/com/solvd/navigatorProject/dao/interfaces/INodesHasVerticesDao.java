package com.solvd.navigatorProject.dao.interfaces;

import com.solvd.navigatorProject.binary.NodeHasVertices;
import com.solvd.navigatorProject.binary.Vertex;

import java.util.List;

public interface INodesHasVerticesDao {
    void joinNodes(NodeHasVertices nhs);

    List<Vertex> getVerticesByNodeId(long id);
}
