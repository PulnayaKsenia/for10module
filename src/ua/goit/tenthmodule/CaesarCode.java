package ua.goit.tenthmodule;

public class CaesarCode {
    public static String encrypt(String text, int offset) {
        int numberOfLetters = 26;
        offset = offset % numberOfLetters + numberOfLetters;

        StringBuilder encrypted = new StringBuilder();
        for (char i : text.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    encrypted.append((char) ('A' + (i - 'A' + offset) % numberOfLetters));
                } else {
                    encrypted.append((char) ('a' + (i - 'a' + offset) % numberOfLetters));
                }
            } else {
                encrypted.append(i);
            }
        }
        return encrypted.toString();
    }

    public static String decrypt(String text, int offset) {
        return encrypt(text, offset);
    }
}
