package com.solvd.navigatorProject.binary;

import java.util.List;
import java.util.Objects;

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
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return id == node.id && Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

