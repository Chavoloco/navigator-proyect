package com.solvd.navigatorProject.binary;

import java.util.List;
import java.util.Objects;

public class Vertex {
    private long id;
    private long distance;
    private List<Node> nodes;

    public Vertex() {
    }

    public Vertex(long distance) {
        this.distance = distance;
    }

    public Vertex(long distance, List<Node> nodes) {
        this.distance = distance;
        this.nodes = nodes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(Node nodes) {
        this.nodes.add(nodes);
    }


    @Override
    public String toString() {
        return "Vertex{" +
                "id=" + id +
                ", distance=" + distance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return id == vertex.id && distance == vertex.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, distance);
    }
}
