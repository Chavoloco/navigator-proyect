package com.solvd.navigatorProject.dao.interfaces;

import com.solvd.navigatorProject.binary.NodeHasVertices;

import java.util.List;

public interface INodesHasVerticesDao {
    void joinNodes(NodeHasVertices nhs);
  
    int deleteNode(long userId, long vertexId);

    int addNode(long userId, long vertexId);

    void joinNodes(long nodeId, long vertexId);
}
