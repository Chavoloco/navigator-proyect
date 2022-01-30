package com.solvd.navigatorProject.binary;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private long id;
    private double weight;
    private List<Node> nodes;

    public Vertex() {
    }

    public Vertex(double weight) {
        this.weight = weight;
        this.nodes = new ArrayList<Node>();
    }

    public Vertex(double weight, List<Node> nodes) {
        this.weight = weight;
        this.nodes = nodes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void addNode(Node nodes) {
        this.nodes.add(nodes);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "id=" + id +
                ", weight=" + weight +
                ", nodes=" + nodes +
                '}';
    }
}
