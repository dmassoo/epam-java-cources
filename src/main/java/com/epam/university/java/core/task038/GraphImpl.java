package com.epam.university.java.core.task038;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphImpl implements Graph {
    private int size;
    private List<Vertex> vertices;
    private Map<Vertex, List<Vertex>> adjustments;

    public GraphImpl(int size) {
        this.size = size;
        vertices = new ArrayList<>();
        adjustments = new HashMap<>();
    }
    /**
     * Create vertex with given id, x and y coordinates.
     *
     * @param id vertex id
     * @param x  x coordinate
     * @param y  y coordinate
     */
    @Override
    public void createVertex(int id, int x, int y) {
        Vertex v = new VertexImpl(id, x, y);
        vertices.add(v);
        adjustments.put(v, new ArrayList<>());
    }

    /**
     * Add connection directed from source vertex to target vertex.
     *
     * @param fromId id of source vertex
     * @param toId   id of target vertex
     */
    @Override
    public void connectVertices(int fromId, int toId) {
        Vertex from = new VertexImpl(0, 0, 0);
        Vertex to = new VertexImpl(0, 0, 0);
        for (Vertex v : vertices) {
            if (v.getId() == fromId) {
                from = v;
            }
            if (v.getId() == toId) {
                to = v;
            }
        }
        List toAdjs = adjustments.get(to);
        toAdjs.add(from);
        adjustments.put(to, toAdjs);
        List fromAdjs = adjustments.get(from);
        fromAdjs.add(to);
        adjustments.put(from, fromAdjs);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    public Map<Vertex, List<Vertex>> getAdjustments() {
        return adjustments;
    }

    public void setAdjustments(Map<Vertex, List<Vertex>> adjustments) {
        this.adjustments = adjustments;
    }
}
