package com.epam.university.java.core.task043;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Task043Impl implements Task043 {

    /**
     * Encode source string with Morse Code.
     *
     * @param sourceString source string
     * @return encoded string
     */
    @Override
    public String encode(String sourceString) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }
        HashMap<String, String> alphabet = new HashMap<>();
        alphabet.put("A", ".-");
        alphabet.put("B", "-...");
        alphabet.put("C", "-.-.");
        alphabet.put("D", "-..");
        alphabet.put("E", ".");
        alphabet.put("F", "..-.");
        alphabet.put("G", "--.");
        alphabet.put("H", "....");
        alphabet.put("I", "..");
        alphabet.put("J", ".---");
        alphabet.put("K", "-.-");
        alphabet.put("L", ".-..");
        alphabet.put("M", "--");
        alphabet.put("N", "-.");
        alphabet.put("O", "---");
        alphabet.put("P", ".--.");
        alphabet.put("Q", "--.-");
        alphabet.put("R", ".-.");
        alphabet.put("S", "...");
        alphabet.put("T", "-");
        alphabet.put("U", "..-");
        alphabet.put("V", "...-");
        alphabet.put("W", ".--");
        alphabet.put("X", "-..-");
        alphabet.put("Y", "-.--");
        alphabet.put("Z", "--..");
        alphabet.put("1", ".----");
        alphabet.put("2", "..---");
        alphabet.put("3", "...--");
        alphabet.put("4", "....-");
        alphabet.put("5", ".....");
        alphabet.put("6", "-....");
        alphabet.put("7", "--...");
        alphabet.put("8", "---..");
        alphabet.put("9", "----.");
        alphabet.put("0", "-----");
        alphabet.put(",", "--..--");
        alphabet.put(" ", " ");
        StringBuilder morseCode = new StringBuilder();
        for (int i = 0; i < sourceString.length(); i++) {
            morseCode.append(alphabet.get(Character.toString(sourceString.charAt(i))));
            morseCode.append(" ");
        }
        morseCode.deleteCharAt(morseCode.length() - 1);
        return morseCode.toString();
    }

    /**
     * Decode source string with Morse Code.
     *
     * @param sourceString source string
     * @return decoded string
     */
    @Override
    public String decode(String sourceString) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }
        HashMap<String, String> alphabet = new HashMap<>();
        alphabet.put(".-", "A");
        alphabet.put("-...", "B");
        alphabet.put("-.-.", "C");
        alphabet.put("-..", "D");
        alphabet.put(".", "E");
        alphabet.put("..-.", "F");
        alphabet.put("--.", "G");
        alphabet.put("....", "H");
        alphabet.put("..", "I");
        alphabet.put(".---", "J");
        alphabet.put("-.-", "K");
        alphabet.put(".-..", "L");
        alphabet.put("--", "M");
        alphabet.put("-.", "N");
        alphabet.put("---", "O");
        alphabet.put(".--.", "P");
        alphabet.put("--.-", "Q");
        alphabet.put(".-.", "R");
        alphabet.put("...", "S");
        alphabet.put("-", "T");
        alphabet.put("..-", "U");
        alphabet.put("...-", "V");
        alphabet.put(".--", "W");
        alphabet.put("-..-", "X");
        alphabet.put("-.--", "Y");
        alphabet.put("--..", "Z");
        alphabet.put(".----", "1");
        alphabet.put("..---", "2");
        alphabet.put("...--", "3");
        alphabet.put("....-", "4");
        alphabet.put(".....", "5");
        alphabet.put("-....", "6");
        alphabet.put("--...", "7");
        alphabet.put("---..", "8");
        alphabet.put("----.", "9");
        alphabet.put("-----", "0");
        alphabet.put("--..--", ",");
        alphabet.put(" ", " ");
        String source = sourceString + " ";
        StringBuilder text = new StringBuilder();
        StringBuilder letter = new StringBuilder();
        int spaces = 0;
        for (int i = 0; i < source.length(); i++) {
            String current = Character.toString(source.charAt(i));
            if (!current.equals(" ")) {
                spaces = 0;
                letter.append(current);
            } else {
                spaces++;
                if (spaces == 1) {
                    text.append(alphabet.get(letter.toString()));
                }
                letter = new StringBuilder();
                if (spaces == 3) {
                    text.append(" ");
                }
            }
        }
        return text.toString();
    }
}
