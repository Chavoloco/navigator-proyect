package com.solvd.navigatorProject.dao.interfaces;

import com.solvd.navigatorProject.binary.Vertex;

public interface IVertexDao extends IEntityDao<Vertex>{

    long getDistanceById(long id);

}
