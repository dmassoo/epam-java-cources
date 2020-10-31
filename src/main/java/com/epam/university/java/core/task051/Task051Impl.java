package com.epam.university.java.core.task051;

import com.epam.university.java.core.task034.Person;

import java.util.Arrays;
import java.util.function.Predicate;

public class Task051Impl implements Task051 {
    /**
     * <p>
     * Write a method that replaces definite article "the" in the sentence
     * with articles "an" or "a". Remember that if the next word begins
     * with a vowel, use "an". In the case of a consonant, use "a".
     * </p>
     *
     * <p>
     * Example: source collection: the dog and the envelope
     * method return: a dog and an envelope
     * replaceThe("the dog and the envelope") ➞ ""
     * </p>
     *
     * @param source source string to replace
     * @return fixed sentence
     */
    @Override
    public String replace(String source) {
        if (source == null || source.isBlank() || !source.equals(source.toLowerCase())) {
            throw new IllegalArgumentException();
        }
        String[] words = source.split("\\s");
        if (Arrays.stream(words).allMatch(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if (s.equals("the")) {
                    return true;
                }
                return false;
            }
        })) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].equals("the")) {
                if (!isVowel(words[i + 1].charAt(0))) {
                    words[i] = "a";
                } else {
                    words[i] = "an";
                }
            }
        }
        String result = String.join(" ", words);
        return result;
    }

    /**
     * Checks if char is vowel.
     *
     * @param c char to check
     * @return true is so
     */
    private boolean isVowel(char c) {
        if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i'
                || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U') {
            return true;
        }
        return false;
    }
}
