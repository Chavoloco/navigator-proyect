package com.solvd.navigatorProject.dao.interfaces;

import com.solvd.navigatorProject.binary.Node;
import com.solvd.navigatorProject.binary.Vertex;

public interface IVertexDao extends IEntityDao<Vertex>{
    void saveNodeA(Node nodeA);

    void saveNodeB(Node nodeB);

    double getWeight();
}
