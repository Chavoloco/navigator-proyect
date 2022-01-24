package com.solvd.navigatorProyect.dao.interfaces;

import com.solvd.navigatorProyect.binary.Node;
import com.solvd.navigatorProyect.binary.Vertex;

import java.util.List;

public interface IVertexDao extends IEntityDao<Vertex>{
    void saveNodeA(Node nodeA);

    void saveNodeB(Node nodeB);

    double getWeight();
}
