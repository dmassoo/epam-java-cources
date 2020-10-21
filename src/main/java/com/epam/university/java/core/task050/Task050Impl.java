package com.epam.university.java.core.task050;

import java.util.Map;
import java.util.Set;

public class Task050Impl implements Task050 {
    /**
     * Calculate maximum cost of the items in backpack.
     *
     * @param size  size of the backpack.
     * @param items map with cost as keys and weight as values of each item.
     * @return maximum cost
     */
    @Override
    public double calculate(int size, Map<Double, Double> items) {
        if (size == 0 || items == null) {
            throw new IllegalArgumentException();
        }
        final Set<Double> doubles = items.keySet();
        Double[] costs = doubles.toArray(new Double[0]);
        Double[] weights = new Double[costs.length];
        for (int i = 0; i < weights.length; i++) {
            weights[i] = items.get(costs[i]);
        }
        return knapsack(size, weights, costs, weights.length);
    }

    /**
     * Helper method.
     *
     * @param capacity of the sack
     * @param weights of items
     * @param costs of items
     * @param n number of items
     * @return max value that we can carry in the sack.
     */
    private double knapsack(double capacity, Double[] weights, Double[] costs, int n) {
        if (n == 0 || capacity == 0) {
            return 0;
        }
        if (weights[n - 1] > capacity){
            return knapsack(capacity, weights, costs, n - 1);
        } else {
            return Math.max(
                    costs[n - 1]
                            + knapsack(capacity - weights[n - 1], weights, costs, n - 1),
                    knapsack(capacity, weights, costs, n - 1));
        }
    }
}
