package com.epam.university.java.core.task047;

public class Task047Impl implements Task047 {
    /**
     * Calculate number of inversions.
     *
     * @param n number of elements in an array.
     * @param a - array of elements.
     * @return number of inversions.
     */
    @Override
    public long calculateInversions(int n, int[] a) {
        long inversions = 0;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[i]) {
                    inversions++;
                }
            }
        }
        return inversions;
    }
}
