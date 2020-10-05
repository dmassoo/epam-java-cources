package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

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
        VertexImpl[] arr = figure.getVertexes().toArray(new VertexImpl[0]);
        for (int i = 0 ; i < arr.length - 1; i++) {
            VertexImpl p = arr[i];
            VertexImpl next =  arr[i+1];
            if(p.x > next.x) {
                VertexImpl temp = p;
                p = next;
                next = temp;
            }
        }
        return false;
    }
}
