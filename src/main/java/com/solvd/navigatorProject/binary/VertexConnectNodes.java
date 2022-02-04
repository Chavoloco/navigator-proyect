package com.solvd.navigatorProject.binary;

public class VertexConnectNodes {
    private long nodesId;
    private long verticesId;

    public VertexConnectNodes() {
    }

    public VertexConnectNodes(long nodesId, long verticesId) {
        this.nodesId = nodesId;
        this.verticesId = verticesId;
    }

    public long getNodesId() {
        return nodesId;
    }

    public void setNodesId(long nodesId) {
        this.nodesId = nodesId;
    }

    public long getVerticesId() {
        return verticesId;
    }

    public void setVerticesId(long verticesId) {
        this.verticesId = verticesId;
    }

    @Override
    public String toString() {
        return "VertexConnectNodes{" +
                "nodesId=" + nodesId +
                ", verticesId=" + verticesId +
                '}';
    }
}
