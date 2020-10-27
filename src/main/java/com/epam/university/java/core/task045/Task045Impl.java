package com.epam.university.java.core.task045;

public class Task045Impl implements Task045 {
    /***
     * <p>
     * Write a method that reverses all the words of input text.
     * All non-letter symbols should stay on the same places.
     * Use Latin alphabet for test only.
     * </p>
     *
     * @param input string to convert
     * @return String - the result of the anagram
     */
    @Override
    public String doAnagram(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        // handling string without letter in that
        boolean hasNoLetters = true;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i))) {
                hasNoLetters = false;
            }
        }
        if (hasNoLetters) {
            return input;
        }
        // handling strings which may contain letters
        StringBuilder word = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder(input);
        int start = 0;
        int end = 0;
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (!(stringBuilder.charAt(i) == ' ')) {
                word.append(stringBuilder.charAt(i));
                end += 1;
            } else {
                if (!(stringBuilder.charAt(i + 1) == ' ') || stringBuilder.length() == i) {
                    stringBuilder.replace(start, end, processWord(word.toString()));
                    start = i + 1;
                    end = i + 1;
                    word = new StringBuilder();
                } else {
                    start++;
                    end = start;
                }
            }
        }
        stringBuilder.replace(start, end, processWord(word.toString()));
        return stringBuilder.toString();
    }

    /**
    * Method to reverse letters in  a single word.
    *
    * @param word word
    * @return word reversed in the right way*
    *
    **/
    private String processWord(String word) {
        StringBuilder stringBuilder = new StringBuilder(word);
        StringBuilder letters = new StringBuilder();
        //finding all letters in the word
        for (int i = 0; i < stringBuilder.length(); i++) {
            char currentChar = stringBuilder.charAt(i);
            if (Character.isLetter(currentChar)) {
                letters.append(currentChar);
            }
        }
        //reversing letters in word
        int j = 0;
        letters.reverse();
        for (int i = 0; i < stringBuilder.length(); i++) {
            char currentChar = stringBuilder.charAt(i);
            if (Character.isLetter(currentChar)) {
                stringBuilder.replace(i, i + 1, String.valueOf(letters.charAt(j)));
                j++;
            }
        }
        return stringBuilder.toString();
    }
}
