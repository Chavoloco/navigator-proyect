package com.solvd.navigatorProject.dao.interfaces;

import com.solvd.navigatorProject.binary.Node;

public interface INodeDao extends IEntityDao<Node> {

    double getAllNodesDistance();

}
