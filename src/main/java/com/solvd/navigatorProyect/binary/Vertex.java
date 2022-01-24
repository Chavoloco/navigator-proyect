package com.solvd.navigatorProyect.binary;

public class Vertex {
    private long id;
    private double weight;
    private Node nodeA;
    private Node nodeB;

    public Vertex(long id, double weight, Node nodeA, Node nodeB) {
        this.id = id;
        this.weight = weight;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
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

    public Node getNodeA() {
        return nodeA;
    }

    public void setNodeA(Node nodeA) {
        this.nodeA = nodeA;
    }

    public Node getNodeB() {
        return nodeB;
    }

    public void setNodeB(Node nodeB) {
        this.nodeB = nodeB;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "id=" + id +
                ", weight=" + weight +
                ", nodeA=" + nodeA +
                ", nodeB=" + nodeB +
                '}';
    }
}
