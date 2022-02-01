package com.solvd.navigatorProject.dao.interfaces;

import com.solvd.navigatorProject.binary.Vertex;

public interface IVertexDao extends IEntityDao<Vertex>{

    double getDistanceById(long id);

}
