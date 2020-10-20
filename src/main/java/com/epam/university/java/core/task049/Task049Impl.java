package com.epam.university.java.core.task049;

import java.util.ArrayList;
import java.util.HashSet;

public class Task049Impl implements Task049 {
    /**
     * Return string with longest common sequence.
     *
     * @param first  string
     * @param second string
     * @return string with longest common sequence.
     * @throws IllegalArgumentException if input parameters are not set or not valid
     */
    @Override
    public String getResultList(String first, String second) {
        if (first == null || second == null || first.isBlank() || second.isBlank()) {
            throw new IllegalArgumentException();
        }
        ArrayList<String> subsFirst = getAllSubstrings(first);
        ArrayList<String> subsSecond = getAllSubstrings(second);
        HashSet<String> set1 = new HashSet<>(subsFirst);
        HashSet<String> set2 = new HashSet<>(subsSecond);
        set1.retainAll(set2);
        ArrayList<String> subs = new ArrayList<>(set1);
        int maxLen = 0;
        String result = "";
        for (String sub : subs) {
            if (sub.length() > maxLen) {
                result = sub;
                maxLen = result.length();
            }
        }
        return result;
    }

    /**
     * Finds all substrings.
     *
     * @param string string
     * @return substrings
     */
    private ArrayList<String> getAllSubstrings(String string) {
        ArrayList<String> strings = new ArrayList<>();
        for (int l = 0; l <= string.length(); l++) {
            for (int i = 0; i <= string.length() - l; i++) {
                strings.add(string.substring(i, i + l));
            }
        }
        return strings;
    }
}

