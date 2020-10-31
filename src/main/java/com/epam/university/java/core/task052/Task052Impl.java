package com.epam.university.java.core.task052;

public class Task052Impl implements Task052 {
    /**
     * Validate bank card number.
     *
     * @param number a bankcard number
     * @return suitable for Luhn demands
     * @throws IllegalArgumentException if input parameters are not set or not valid
     */
    @Override
    public boolean validateCard(long number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        StringBuilder numString = new StringBuilder(String.valueOf(number));
        int numLength = numString.length();
        if (numLength > 19 || numLength < 14) {
            throw new IllegalArgumentException();
        }
        int lastDigit = Integer.parseInt(numString.substring(numLength - 1));
        numString = numString.deleteCharAt(numLength - 1);
        numString = numString.reverse();
        int sum = sum(numString);
        int value = 10 - sum % 10;
        if (value == lastDigit) {
            return true;
        }
        return false;
    }

    /**
     * Sum of digits.
     *
     * @param numString stringBuilder
     * @return sum
     */
    private int sum(StringBuilder numString) {
        int sum = 0;
        int numLength = numString.length(); // it is not recalculates after char deletion...
        for (int i = 0; i < numLength; i++) {
            if (i % 2 == 0) {
                int doubled = Integer.parseInt(numString.substring(i, i + 1)) * 2;
                if (doubled >= 10) {
                    doubled = doubled / 10 + doubled % 10;
                }
                numString.setCharAt(i,  Integer.toString(doubled).charAt(0));
            }
            sum += Integer.parseInt(Character.toString(numString.charAt(i)));
        }
        return sum;
    }
}
