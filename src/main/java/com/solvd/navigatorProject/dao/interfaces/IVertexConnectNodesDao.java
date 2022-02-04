package com.solvd.navigatorProject.dao.interfaces;

import com.solvd.navigatorProject.binary.VertexConnectNodes;
import com.solvd.navigatorProject.binary.Vertex;

import java.util.List;

public interface IVertexConnectNodesDao {
    void joinNodes(VertexConnectNodes nhs);

    List<Vertex> getVerticesByNodeId(long id);

    void deleteAllJoinedNodes();
}
