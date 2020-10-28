package com.epam.university.java.core.task038;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Task038Impl implements Task038 {
    /**
     * Create new Graph instance and execute collection of actions. Return
     * the result graph instance.
     *
     * @param sourceGraph initial graph instance
     * @param actions     collection of actions
     * @return updated graph instance
     */
    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions) {
        for (GraphAction action : actions) {
            action.run(sourceGraph);
        }
        return sourceGraph;
    }

    /**
     * Find the path with minimum possible sum of its edges weights.
     * Path must contain source and target vertex.
     * If path doesn't exist, return empty collection.
     *
     * @param graph   graph instance
     * @param startId is id of source vertex
     * @param endId   is id of target vertex
     * @return collection of vertices from source to target with minimum
     * possible sum of edge weights.
     */
    @Override
    public Collection<Vertex> getShortestPath(Graph graph, int startId, int endId) {
        return dijkstra((GraphImpl) graph, startId, endId);
    }

    private double distanceBetweenVertices(Vertex v1, Vertex v2) {
        double dx2 = Math.pow(v2.getX() - v1.getX(), 2);
        double dy2 = Math.pow(v2.getY() - v1.getY(), 2);
        double distance = Math.sqrt(dx2 + dy2);
        return distance;
    }

    private Vertex getClosestVertex(Vertex start, Set<Vertex> B) {
        Iterator<Vertex> iterator = B.iterator();
        Vertex closestVertex = B.iterator().next();
        double minDistance = distanceBetweenVertices(start, closestVertex);
        while (iterator.hasNext()) {
            Vertex currentVertex = iterator.next();
            boolean isCurrentCloser = minDistance > distanceBetweenVertices(start, currentVertex);
            if (isCurrentCloser) {
                closestVertex = currentVertex;
                minDistance = distanceBetweenVertices(start, currentVertex);
            }
        }
        return closestVertex;
    }


    private Collection<Vertex> dijkstra(GraphImpl graph, int startId, int endId) {
        //path from vertex to itself
        if (startId == endId) {
            return new ArrayList<>();
        }
        Set<Vertex> A = new HashSet<>();
        Set<Vertex> B = new HashSet<>();
        Map<Vertex, Double> distances = new HashMap<>();
        Map<Vertex, Vertex> Ps = new HashMap<>();
        //initializing sets and map
        Vertex startVertex = null;
        Vertex endVertex = null;
        for (Vertex v : graph.getVertices()) {
            if (v.getId() == startId) {
                startVertex = v;
                A.add(v);
                distances.put(startVertex, 0.0);
            } else {
                B.add(v);
                distances.put(v, Double.MAX_VALUE);
                if (v.getId() == endId) {
                    endVertex = v;
                }
            }
        }
        // is startId is invalid
        if (A.isEmpty()) {
            throw new IllegalArgumentException("There is no vertex with such id");
        }
        // dijkstra's algorithm

        for (Vertex v : graph.getAdjustments().get(startVertex)) {
            Ps.put(v, startVertex);
        }
        while (!B.isEmpty()) {
            Vertex closest = getClosestVertex(startVertex, B);
            distances.put(closest, distanceBetweenVertices(startVertex, closest));
            for (Vertex u : graph.getAdjustments().get(closest)) {
                if (distances.get(u) > distances.get(closest)
                        + distanceBetweenVertices(u, closest)) {
                    Double currentDistance = Math.min(distances.get(u),
                            distances.get(closest) + distanceBetweenVertices(u, closest));
                    distances.put(u, currentDistance);
                    Ps.put(u, closest);
                }
            }
            A.add(closest);
            B.remove(closest);
        }
        //restoring the path
        List<Vertex> pathReversed = new ArrayList<>();
        Vertex currentAncestor = endVertex;
        pathReversed.add(endVertex);
        for (Map.Entry e : Ps.entrySet()) {
            currentAncestor = Ps.get(currentAncestor);
            pathReversed.add(currentAncestor);
            if (currentAncestor.getId() == startId) {
                break;
            }
        }
        pathReversed.add(startVertex);
        Collections.reverse(pathReversed);
        return pathReversed;
    }
}
