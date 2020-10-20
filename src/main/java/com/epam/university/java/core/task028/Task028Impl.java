package com.epam.university.java.core.task028;

public class Task028Impl implements Task028 {
    /**
     * Find the number of ways that a given integer <code>value</code> can be expressed as the
     * sum of the Nth power of unique, natural numbers.
     *
     * <p>
     * Examples:
     * value is 10, power is 2, result is 1 because 10 = 1^2 + 3^2
     * value is 100, power is 2, result is 3 because 100 = 10^2 =
     * 6^2 + 8^2 = 1^2 + 3^2 + 4^2 + 5^2 + 7^2
     * </p>
     *
     * @param value value number
     * @param power power
     * @return number of ways
     */
    @Override
    public int getWays(int value, int power) {
        return getWaysUtil(value, power, 1);
    }

    /**
     * Helper method.
     *
     * @param value value number
     * @param power power
     * @return number of ways
     */
    private int getWaysUtil(int value, int power, int currentNumber) {
        int diff = value - (int) Math.pow(currentNumber, power);
        if (diff == 0) {
            return 1;
        }
        if (diff < 0) {
            return 0;
        }
        return getWaysUtil(diff, power, currentNumber + 1)
                + getWaysUtil(value, power, currentNumber + 1);
    }
}
