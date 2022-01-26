package com.solvd.navigatorProject.binary;

public class Node {
    private long id;
    private String name;
    private long positionX;
    private long positionY;

    public Node() {
    }

    public Node( long positionX, long positionY, String name) {
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
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

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", positionX=" + positionX +
                ", positionY=" + positionY +
                '}';
    }
}

