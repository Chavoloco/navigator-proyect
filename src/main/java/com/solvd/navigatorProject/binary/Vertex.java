package com.solvd.navigatorProject.binary;

import java.util.List;

public class Vertex {
    private long id;
    private double distance;
    private long destination;
    private long source;

    public Vertex() {
    }

    public Vertex(double distance) {
        this.distance = distance;
    }

    public Vertex(long source, long destination, double distance) {
        this.distance = distance;
        this.source = source;
        this.destination = destination;
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

    public long getDestination() {
        return destination;
    }

    public void setDestination(long destination) {
        this.destination = destination;
    }

    public long getSource() {
        return source;
    }

    public void setSource(long source) {
        this.source = source;
    }

    @Override
    public String
    toString() {
        return "Vertex{" +
                "id=" + id +
                ", distance=" + distance +
                '}';
    }
}
