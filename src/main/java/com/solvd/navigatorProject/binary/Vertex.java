package com.solvd.navigatorProject.binary;

import java.util.List;

public class Vertex {
    private long id;
    private double distance;
    private List<Node> nodes;

    public Vertex() {
    }

    public Vertex(double distance, List<Node> nodes) {
        this.distance = distance;
        this.nodes = nodes;
    }

    public Vertex(double distance) {
        this.distance = distance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
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
                ", nodes=" + nodes +
                '}';
    }
}
