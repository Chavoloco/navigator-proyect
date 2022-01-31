package com.solvd.navigatorProject.binary;

import java.util.List;

public class Node {
    private long id;
    private String name;
    private long positionX;
    private long positionY;
    private List<Vertex> vertices;

    public Node(String name, long positionX, long positionY, List<Vertex> vertices) {
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
        this.vertices = vertices;
    }

    public Node(String name, long positionX, long positionY) {
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public Node() {
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

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    public void addVertices(Vertex vertex){
        this.vertices.add(vertex);
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", positionX=" + positionX +
                ", positionY=" + positionY +
                ", vertices" + vertices +
                '}';
    }
}

