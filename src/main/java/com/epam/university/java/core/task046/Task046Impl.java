package com.epam.university.java.core.task046;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task046Impl implements Task046 {
    /**
     * List of strings , each containing k numbers of dolls from smaller to larger
     * separated by space.
     *
     * @param k the number of dolls that can be taken at a time
     * @param n total number of nesting dolls
     * @return List of strings , each containing k numbers of dolls from smaller to larger
     */
    @Override
    public List<String> assembleMatryoshka(Integer k, Integer n) {
        List<String> combinations = new ArrayList<>();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = i;
        }
        return null;
    }

    private void combinationUtil(List<String> combinations, int n, int k, int i, int[] curComb) {
        if (i == k) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < curComb.length; j++) {
                stringBuilder.append(curComb[j]);
            }
            combinations.add(stringBuilder.toString());
        }
        if (i >= n) {
            return;
        }

    }
}
