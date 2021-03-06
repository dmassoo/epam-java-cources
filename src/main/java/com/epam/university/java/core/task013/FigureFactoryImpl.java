package com.epam.university.java.core.task013;

public class FigureFactoryImpl implements FigureFactory {
    /**
     * Create figure with designated amount of vertexes.
     *
     * @param vertexCount amount of vertexes
     * @return figure instance
     */
    @Override
    public Figure newInstance(int vertexCount) {
        if (vertexCount < 3) {
            throw new IllegalArgumentException();
        }
        Figure figure = new FigureImpl();
        ((FigureImpl) figure).verticeCount = vertexCount;
        return figure;
    }

    /**
     * Create new vertex instance with designated coordinates.
     *
     * @param x first coordinate
     * @param y second coordinate
     * @return vertex instance
     */
    @Override
    public Vertex newInstance(int x, int y) {

        return new VertexImpl(x, y);
    }
}
