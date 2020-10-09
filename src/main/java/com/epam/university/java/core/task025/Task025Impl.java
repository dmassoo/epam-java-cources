package com.epam.university.java.core.task025;

public class Task025Impl implements Task025 {
    /**
     * Martian exploration ship has been broken and sent several SOS messages back to Earth.
     * Some letters of the SOS message are altered by cosmic radiation during transmission.
     * Given the signal received by Earth as a string, determine how many letters of SOS
     * has been changed by radiation.
     *
     * <p>
     * Example: source SOSOASOB, result is 4
     * </p>
     *
     * @param sourceMessage received message
     * @return amount of altered letters
     */
    @Override
    public int getAmountOfAlteredLetters(String sourceMessage) {
        if (sourceMessage == null) {
            throw new IllegalArgumentException();
        }
        int altered = 0;
        for (int i = 0; i < sourceMessage.length(); i++) {
            if (i % 3 == 1 && sourceMessage.charAt(i) != 'O') {
                altered++;
            }
            if ((i % 3 == 0 || i % 3 == 2) && sourceMessage.charAt(i) != 'S') {
                altered++;
            }
        }
        return altered;
    }
}
