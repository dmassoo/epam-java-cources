package com.epam.university.java.core.task013;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Task013Impl implements Task013 {
    /**
     * Invoke actions with <code>figure</code> instance.
     *
     * @param figure  source figure
     * @param actions collection of actions
     * @return modified figure
     */
    @Override
    public Figure invokeActions(Figure figure, Collection<FigureAction> actions) {
        boolean isNull = figure == null || actions == null;
        if (isNull) {
            throw new IllegalArgumentException();
        }
        boolean isEmpty = actions.isEmpty();
        boolean isTooMuch = actions.size() > ((FigureImpl) figure).verticeCount;
        if (isEmpty || isTooMuch) {
            throw new IllegalArgumentException();
        }
        for (FigureAction action : actions) {
            action.run(figure);
        }
        return figure;
    }

    /**
     * Check if figure is convex polygon. Convex polygon is a simple polygon in which
     * no line segment between two points on the boundary goes outside the polygon.
     *
     * @param figure figure go check
     * @return is figure convex polygon
     */
    @Override
    public boolean isConvexPolygon(Figure figure) {
        if (figure == null) {
            throw new IllegalArgumentException();
        }
        List<Vertex> vertices = new LinkedList<>(
                Arrays.asList(figure.getVertexes().toArray(new Vertex[0])));
        Vertex left = vertices.get(0);
        //find the most left and low vertice
        for (Vertex vertex : vertices) {
            if (vertex.getX() <= left.getX() && vertex.getY() <= left.getY()) {
                left = vertex;
            }
        }
        final Vertex actuallyLeft = left;
        vertices.remove(left);
        //sort by tg using custom comparator
        vertices.sort(new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                double tg1 = ((double) (o1.getY() - actuallyLeft.getY())) /
                        ((double) (o1.getX() - actuallyLeft.getX()));
                double tg2 = ((double) (o2.getY() - actuallyLeft.getY())) /
                        ((double) (o2.getX() - actuallyLeft.getX()));

                //TODO: if tgs are equal then compare by distance from the left
                if (tg1 > tg2) {
                    return -1;
                } else if (tg2 == tg1) {
                    double d1 = distance(actuallyLeft, o1);
                    double d2 = distance(actuallyLeft, o2);
                    if (d1 > d2) {
                        return 1;
                    } else if (d1 < d2) {
                        return -1;
                    } else {
                        return 0;
                    }
                } else {
                    return 1;
                }
            }
        });
        vertices.add(0, left);
        //check convex using vector product
        //TODO: if was zero then any sign is ok
        int signum = 0;
        for (int i = 0; i < vertices.size() - 1; i++) {
            int currentProduct = product(vertices.get(i), vertices.get(i + 1));
            if (Integer.signum(currentProduct) != 0) {
                signum = Integer.signum(currentProduct);
                break;
            }
        }
        int currentProduct;
        for (int i = 0; i < vertices.size() - 1; i++) {
             currentProduct = product(vertices.get(i), vertices.get(i + 1));
            if (Integer.signum(currentProduct) != 0 && Integer.signum(currentProduct) != signum) {
                return false;
            }

        }
        return true;
    }

    private int product(Vertex v1, Vertex v2) {
        return v1.getX() * v2.getY() - v1.getY() * v2.getX();
    }

    private double distance(Vertex from, Vertex to) {
        return Math.sqrt(Math.pow(to.getX() - from.getX(), 2)
                + Math.pow(to.getY() - from.getY(), 2));
    }
}
