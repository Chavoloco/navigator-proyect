package com.solvd.navigatorProject.binary;

public class Node {
    private long id;
    private String name;
    private long positionX;
    private long positionY;
    private long vertexId;

    public Node() {
    }

    public Node( String name, long positionX, long positionY, long vertexId) {
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
        this.vertexId = vertexId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPositionX() {
        return positionX;
    }

    public void setPositionX(long positionX) {
        this.positionX = positionX;
    }

    public long getPositionY() {
        return positionY;
    }

    public void setPositionY(long positionY) {
        this.positionY = positionY;
    }

    public long getVertexId() {
        return vertexId;
    }

    public void setVertexId(long vertexId) {
        this.vertexId = vertexId;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", positionX=" + positionX +
                ", positionY=" + positionY +
                ", vertexId=" + vertexId +
                '}';
    }
}

