package com.solvd.navigatorProject.dao.interfaces;

import com.solvd.navigatorProject.binary.Node;
import com.solvd.navigatorProject.binary.NodeHasVertices;
import com.solvd.navigatorProject.binary.Vertex;

import java.util.List;

public interface INodesHasVerticesDao {
    int deleteNode(long userId, long vertexId);

    int addNode(long userId, long vertexId);

    void joinNodes(long nodeId, long vertexId);
}
