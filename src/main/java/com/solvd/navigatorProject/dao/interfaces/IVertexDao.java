package com.solvd.navigatorProject.dao.interfaces;

import com.solvd.navigatorProject.binary.Node;
import com.solvd.navigatorProject.binary.Vertex;

import java.util.List;

public interface IVertexDao extends IEntityDao<Vertex>{
    double getWeightById();

}
