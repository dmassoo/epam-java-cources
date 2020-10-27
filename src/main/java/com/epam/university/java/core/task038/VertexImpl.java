package com.epam.university.java.core.task038;

import java.util.ArrayList;
import java.util.Collection;

public class VertexImpl implements Vertex {
    private int id;
    private int x;
    private int y;

    public VertexImpl(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }
    /**
     * Get id of vertex.
     *
     * @return id value
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Get x coordinate of vertex.
     *
     * @return x coordinate value
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * Get y coordinate of vertex.
     *
     * @return y coordinate value
     */
    @Override
    public int getY() {
        return y;
    }
}
