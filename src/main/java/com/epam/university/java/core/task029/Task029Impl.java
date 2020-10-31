package com.epam.university.java.core.task029;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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
        //transform to 2-d char array
        final String[] strings = rows.toArray(new String[0]);
        int r = strings.length;
        int c = strings[0].length();
        char[][] field = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                field[i][j] = strings[i].charAt(j);
            }
        }
        final String[] wordsArr = words.toArray(new String[0]);
        //solution and result transformation to the right interface
        fillCrossword(field, wordsArr, 0);
        List<char[]> chars = Arrays.asList(field);
        StringBuilder row = new StringBuilder();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < chars.size(); i++) {
            for (int j = 0; j < chars.get(0).length; j++) {
                row.append(field[i][j]);
            }
            result.add(row.toString());
            row = new StringBuilder();
        }
        return result;
    }

    private void fillCrossword(char[][] field, String[] words, int wordNumber) {
        if (wordNumber == words.length) {
            return;
        }
        String word = words[wordNumber];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] == '-' || field[i][j] == word.charAt(0)) {
                    if (canPlaceWordHorizontally(field, word, i, j)) {
                        placeWordHorizontally(field, word, i, j);
                        fillCrossword(field, words, wordNumber + 1);
                    }
                    if (canPlaceWordVertically(field, word, i, j)) {
                        placeWordVertically(field, word, i, j);
                        fillCrossword(field, words, wordNumber + 1);
                    }
                }
            }
        }
    }

    private boolean canPlaceWordHorizontally(char[][] field, String word, int row, int col) {
        boolean fieldHasLeftGap = false;
        if (col > 0) {
            fieldHasLeftGap = field[row][col - 1] == '-';
        }
        boolean isOutOfBoundaries = col + word.length() > field[0].length;
        boolean fieldHasRightGap = false;
        if (!isOutOfBoundaries && col + word.length() < field[0].length) {
            fieldHasRightGap = field[row][col + word.length()] == '-';
        }
        if (fieldHasLeftGap || isOutOfBoundaries || fieldHasRightGap) {
            return false;
        }
        boolean isValid;
        for (int i = 0; i < word.length(); i++) {
            isValid = field[row][col + i] == '-' || field[row][col + i] == word.charAt(i);
            if (!isValid) {
                return false;
            }
        }
        return true;
    }

    private void placeWordHorizontally(char[][] field, String word, int row, int col) {
        for (int i = 0; i < word.length(); i++) {
            field[row][col + i] = word.charAt(i);
        }
    }

    private boolean canPlaceWordVertically(char[][] field, String word, int row, int col) {
        boolean fieldHasUpperGap = false;
        if (row > 0) {
            fieldHasUpperGap = field[row - 1][col] == '-';
        }
        boolean isOutOfBoundaries = row + word.length() > field.length;
        boolean fieldHasLowerGap = false;
        if (!isOutOfBoundaries && row + word.length() < field.length) {
            fieldHasLowerGap = field[row + word.length()][col] == '-';
        }
        if (fieldHasUpperGap || isOutOfBoundaries || fieldHasLowerGap) {
            return false;
        }
        boolean isValid;
        for (int i = 0; i < word.length(); i++) {
            isValid = field[row + i][col] == '-' || field[row + i][col] == word.charAt(i);
            if (!isValid) {
                return false;
            }
        }
        return true;
    }

    private void placeWordVertically(char[][] field, String word, int row, int col) {
        for (int i = 0; i < word.length(); i++) {
            field[row + i][col] = word.charAt(i);
        }
    }
}
