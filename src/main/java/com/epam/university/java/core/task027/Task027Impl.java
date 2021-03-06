package com.epam.university.java.core.task027;

import java.util.ArrayList;
import java.util.Collection;

public class Task027Impl implements Task027 {
    /**
     * Given a number string that can be split into the sequence of two or more positive
     * integers [a1, a2, ..., an] satisfying the following conditions:
     *
     * <p>
     * 1. ai - a(i-1) = 1 for any element
     * 2. No ai contains a leading zero
     * 3. Content of the sequence cannot be rearranged.
     * </p>
     *
     * <p>
     * You should extract that numbers or return an empty collection if it is not possible.
     * </p>
     *
     * <p>
     * Example: given a string "1234", result should be [1, 2, 3, 4]
     * Example: given a string "91011", result should be [9, 10, 11]
     * Example: given a string "99100", result should be [99, 100]
     * Example: given a string "4123", result should be []
     * </p>
     *
     * @param sourceString source string
     * @return collection of extracted integers
     */
    @Override
    public Collection<Integer> extract(String sourceString) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }
        if (sourceString.length() < 2) {
            return new ArrayList<>();
        }
        int len = sourceString.length();
        int maxElementLen = (int) (len + 1.0) / 2;
        ArrayList<Integer> elems = new ArrayList<>();
        for (int j = 1; j <= maxElementLen; j++) {
            int c = j;
            for (int i = 0; i < len; i += c) {
                String elem = sourceString.substring(i, Math.min(i + c, len));
                if (elem.charAt(0) == '0') {
                    elems.clear();
                    break;
                }
                elems.add(Integer.parseInt(elem));
                if (i >= 1 && elems.get(elems.size() - 1) - elems.get(elems.size() - 2) != 1) {
                    elems.clear();
                    break;
                }
                if (isOfNines(elem)) {
                    c++;
                    i--;
                }
            }
            if (elems.size() > 0) {
                return elems;
            }
        }
        return elems;
    }

    private boolean isOfNines(String elem) {
        for (int i = 0; i < elem.length(); i++) {
            if (elem.charAt(i) != '9') {
                return false;
            }
        }
        return true;
    }
}
