package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;

public class FigureImpl implements Figure {
    ArrayList<Vertex> vertices = new ArrayList<>();
    int verticeCount = vertices.size();

    /**
     * Add vertex to figure with designated coordinates.
     *
     * @param vertex vertex to add
     */
    @Override
    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }

    /**
     * Get all vertexes of figure.
     *
     * @return collection of vertexes
     */
    @Override
    public Collection<Vertex> getVertexes() {
        return vertices;
    }
}
