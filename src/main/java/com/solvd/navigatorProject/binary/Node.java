package com.solvd.navigatorProject.binary;

import java.util.List;

public class Node {
    private long id;
    private String name;
    private List<Vertex> vertices;


    public Node(String name, List<Vertex> vertices) {
        this.name = name;
        this.vertices = vertices;
    }

    public Node(String name) {
        this.name = name;
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
                ", vertices=" + vertices +
                '}';
    }
}

