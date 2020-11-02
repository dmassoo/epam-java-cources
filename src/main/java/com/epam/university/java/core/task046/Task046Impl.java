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
        combinations(n, k, combinations);
        return combinations;
    }

    private void combinations(Integer n, Integer k, List<String> combinations) {
        int i;
        int p;
        int[] arr = new int[k];
        for (i = 0; i < k; i++) {
            arr[i] = i;
        }
        while (true) {
            String combination = "";
            for (i = 0; i < k; i++) {
                combination += arr[i];
                if (i == k - 1) {
                    continue;
                }
                combination += " ";
            }
            combinations.add(combination);
            if (arr[k - 1] < n - 1) {
                arr[k - 1]++;
            } else {
                for (p = k - 1; p > 0; p--) {
                    if (arr[p] - arr[p - 1] > 1) {
                        break;
                    }
                }
                if (p == 0) {
                    break;
                }
                arr[p - 1]++;
                for (i = p; i < k; i++) {
                    arr[i] = arr[i - 1] + 1;
                }
            }
        }
    }
}


