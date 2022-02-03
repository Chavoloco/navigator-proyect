package com.solvd.navigatorProject.dao.interfaces;

import com.solvd.navigatorProject.binary.Node;
import com.solvd.navigatorProject.binary.Vertex;

public interface IVertexDao extends IEntityDao<Vertex>{

    double getDistanceById(long id);

    void setDestinationAndSource(long source, long destination, double distance);

}
