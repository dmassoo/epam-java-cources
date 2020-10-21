package com.epam.university.java.core.task029;

import java.util.Collection;

public class Task029Impl implements Task029 {
    /**
     * Given 10x10 crossword grid, each line in <code>rows</code> collection presents single
     * line in a crossword. Cells in the grid have values + and -. Cells marked with a -
     * need to be filled up with an appropriate characters.
     *
     * <p>
     * Example:
     * source matrix is:
     * +-++++++++
     * +-++++++++
     * +-++++++++
     * +-----++++
     * +-+++-++++
     * +-+++-++++
     * +++++-++++
     * ++------++
     * +++++-++++
     * +++++-++++
     * words list is [LONDON, DELHI, ICELAND, ANKARA]
     * result matrix is
     * +L++++++++
     * +O++++++++
     * +N++++++++
     * +DELHI++++
     * +O+++C++++
     * +N+++E++++
     * +++++L++++
     * ++ANKARA++
     * +++++N++++
     * +++++D++++
     *
     * </p>
     *
     * @param rows  crossword definition
     * @param words words to fill in
     * @return filled crossword
     */
    @Override
    public Collection<String> fillCrossword(Collection<String> rows, Collection<String> words) {
        if (rows == null || words == null) {
            throw new IllegalArgumentException();
        }
        String[] fieldRows = rows.toArray(new String[0]);
        int[] horizontalGaps = new int[10];
        int[] verticalGaps = new int[10];
        for (int i = 0; i < fieldRows[i].length(); i++) {
            int gaps = 0;
            for (int j = 0; j < fieldRows[i].length(); j++) {
                if (fieldRows[i].charAt(j) == '-') {
                    gaps++;
                }
            }
            horizontalGaps[i] = gaps;
        }
        return null;
    }

    private Collection<String> crosswordUtil(Collection<String> rows,
                                             Collection<String> words,
                                             int wordNumber) {
        if (wordNumber == words.size() - 1) {
            return rows;
        }
        String word = words.toArray(new String[0])[wordNumber];
        for (int i = 0; i < rows.size(); i++) {
            for (int j = 0; j < rows.size(); j++) {
            }
        }
        return null;
    }
}
