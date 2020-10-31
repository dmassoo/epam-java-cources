package com.epam.university.java.core.task048;

import java.util.ArrayList;
import java.util.Collection;

public class Task048Impl implements Task048 {
    /**
     * Return collection of Armstrong numbers.
     *
     * @param from int value of start range number
     * @param to   int value of end range number
     * @return collection of Armstrong numbers
     * @throws IllegalArgumentException if input parameters are not set or not valid
     */
    @Override
    public Collection<Integer> getArmstrongNumbers(Integer from, Integer to) {
        if (from == null || to == null || (from < 0 && to < 0)) {
            throw new IllegalArgumentException();
        }
        ArrayList<Integer> armstrongNumbers = new ArrayList<>();
        for (int n = from; n <= to; n++) {
            String numberString = String.valueOf(n);
            int lengthOfNumber = numberString.length();
            int power = lengthOfNumber;
            int sumOfDigits = 0;
            for (int i = 0; i < lengthOfNumber; i++) {
                sumOfDigits += Math.pow(Integer.parseInt(numberString.substring(i, i + 1)), power);
            }
            if (sumOfDigits == n) {
                armstrongNumbers.add(n);
            }
        }
        return armstrongNumbers;
    }
}
