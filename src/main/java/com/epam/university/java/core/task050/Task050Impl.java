package com.epam.university.java.core.task050;


import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

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
        //key is cost, value is weight
        Map<Double, Double> unitCosts = new HashMap<>();
        for (Map.Entry<Double, Double> item : items.entrySet()) {
            Double unitCost = item.getKey() / item.getValue();
            unitCosts.put(unitCost, item.getValue());
        }
        //sored set of unit costs.
        SortedSet<Double> costs = new TreeSet<>(unitCosts.keySet()).descendingSet();
        double currentSize = 0;
        double value = 0;
        //iterating over sorted by desc set of (C/W)s.
        for (Double cost : costs) {
            if (currentSize >= size) {
                break;
            }
            if (currentSize + unitCosts.get(cost) <= size) {
                currentSize += unitCosts.get(cost);
                value += (double) Math.round(unitCosts.get(cost) * cost * 1000d) / 1000d;
            } else {
                value += (double) Math.round(cost * (size - currentSize) * 1000d) / 1000d;
                break;
            }
        }
        return value;
    }
}
