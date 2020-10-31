package com.epam.university.java.core.task044;

import java.util.List;

public class Task044Impl implements Task044 {
    /**
     * count of traces in the snow.
     *
     * @param points total number of points
     * @param lines  each element is a two points separated by space
     * @return number of traces
     */
    @Override
    public int findCountOfTraces(Integer points, List<String> lines) {
        if (points == null || lines == null) {
            throw new IllegalArgumentException();
        }
        int[][] adjustmentMatrix = new int[points][points];
        boolean[] isVisited = new boolean[points];
        for (String line : lines) {
            addEdge(adjustmentMatrix, line);
        }
        int components = components(isVisited, adjustmentMatrix);
        return components;
    }

    private void addEdge(int[][] adjustmentMatrix, String edge) {
        int from = Integer.parseInt(edge.split(" ")[0]);
        int to = Integer.parseInt(edge.split(" ")[1]);
        if (adjustmentMatrix.length < from || adjustmentMatrix.length < to) {
            throw new IllegalArgumentException();
        }
        adjustmentMatrix[from - 1][to - 1] = 1;
        adjustmentMatrix[to - 1][from - 1] = 1;
    }

    private void dfs(int v, boolean[] isVisited, int[][] adjustmentMatrix) {
        isVisited[v] = true;
        for (int i = 0; i < adjustmentMatrix[v].length; i++) {
            if (adjustmentMatrix[v][i] == 1 && !isVisited[i]) {
                dfs(i, isVisited, adjustmentMatrix);
            }
        }
    }

    private int components(boolean[] isVisited, int[][] adjustmentMatrix) {
        int components = 0;
        for (int i = 0; i < isVisited.length; i++) {
            if (!isVisited[i]) {
                components++;
                dfs(i, isVisited, adjustmentMatrix);
            }
        }
        return components;
    }
}
