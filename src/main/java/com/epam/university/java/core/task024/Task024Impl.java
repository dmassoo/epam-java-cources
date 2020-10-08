package com.epam.university.java.core.task024;

import java.util.ArrayList;
import java.util.Collection;

public class Task024Impl implements Task024 {
    /**
     * Given a string with camel case word, you should separate this string
     * into collection of words.
     *
     * <p>
     * Example: source string is saveChangesInTheEditor, result is
     * [save, changes, in, the, editor]
     * </p>
     *
     * @param source source string
     * @return collection of words
     */
    @Override
    public Collection<String> getWordsCount(String source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        if (source.length() == 0) {
            return new ArrayList<>();
        }
        int j = 0;
        ArrayList<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        if (Character.isUpperCase(source.charAt(0))) {
            word.append(Character.toLowerCase(source.charAt(0)));
            j++;
        }
        for (int i = j; i < source.length(); i++) {
            if (Character.isUpperCase(source.charAt(i))) {
                words.add(word.toString());
                word = new StringBuilder();
                word.append(Character.toLowerCase(source.charAt(i)));
            } else {
                word.append(source.charAt(i));
            }
        }
        words.add(word.toString());
        return words;
    }
}
