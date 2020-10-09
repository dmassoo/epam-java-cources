package com.epam.university.java.core.task026;

public class Task026Impl implements Task026 {
    /**
     * Encrypt source string with Caesar Cipher shifting by <code>shift</code> value.
     *
     * @param sourceString source string
     * @param shift        shift value
     * @return encrypted string
     */
    @Override
    public String encrypt(String sourceString, int shift) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }
        StringBuilder result = new StringBuilder();
        for (char character : sourceString.toCharArray()) {
            if (Character.isLetter(character)) {
                if (Character.isLowerCase(character)) {
                    int originalAlphabetPosition = character - 'a';
                    int newAlphabetPosition = (originalAlphabetPosition + shift) % 26;
                    char newCharacter = (char) ('a' + newAlphabetPosition);
                    result.append(newCharacter);
                } else if (Character.isUpperCase(character)) {
                    int originalAlphabetPosition = character - 'A';
                    int newAlphabetPosition = (originalAlphabetPosition + shift) % 26;
                    char newCharacter = (char) ('A' + newAlphabetPosition);
                    result.append(newCharacter);
                }
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    /**
     * Decrypt protected string by unshifting it by <code>shift</code> value.
     *
     * @param encryptedString encrypted string
     * @param shift           shift value
     * @return decrypted string
     */
    @Override
    public String decrypt(String encryptedString, int shift) {
        if (encryptedString == null) {
            throw new IllegalArgumentException();
        }
        StringBuilder result = new StringBuilder();
        for (char character : encryptedString.toCharArray()) {
            if (Character.isLetter(character)) {
                if (Character.isLowerCase(character)) {
                    int originalAlphabetPosition = character - 'a';
                    int newAlphabetPosition = (26 * 1000 + originalAlphabetPosition - shift) % 26;
                    char newCharacter = (char) ('a' + newAlphabetPosition);
                    result.append(newCharacter);
                } else if (Character.isUpperCase(character)) {
                    int originalAlphabetPosition = character - 'A';
                    int newAlphabetPosition = (26 * 1000 + originalAlphabetPosition - shift) % 26;
                    char newCharacter = (char) ('A' + newAlphabetPosition);
                    result.append(newCharacter);
                }
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }
}
