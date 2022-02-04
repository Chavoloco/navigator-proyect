package com.solvd.navigatorProject.services.interfaces;

import com.solvd.navigatorProject.binary.Vertex;
import com.solvd.navigatorProject.binary.VertexConnectNodes;

import java.util.List;

public interface IVertexConnectNodes {

    void joinNodes(VertexConnectNodes nhs);

    List<Vertex> getVerticesByNodeId(long id);

    void deleteAllJoinedNodes();

}
