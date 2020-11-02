package com.epam.university.java.core.task053;

import java.util.ArrayList;

public class Task053Impl implements Task053 {
    /**
     * Calculate the result.
     *
     * @param input Mathematical expression.
     * @return double result
     * @throws IllegalArgumentException if input parameters not valid
     */
    @Override
    public double calculate(String input) {
        if (input == null || !isValid(input)) {
            throw new IllegalArgumentException();
        }

        InfToPost intToPost = new InfToPost(input);
        ArrayList<String> strings = intToPost.toPostfix();
        ParsePost parsePost = new ParsePost(strings);
        return parsePost.parse();
    }

    private boolean isValid(String string) {
        String validChars = "0123456789+-*/^()";
        for (int i = 0; i < string.length(); i++) {
            if (validChars.contains(Character.toString(string.charAt(i)))) {
                continue;
            }
            return false;
        }
        if (!Character.isDigit(string.charAt(string.length() - 1))
                && string.charAt(string.length() - 1) != ')') {
            return false;
        }
        return true;
    }
}
