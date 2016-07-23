package ua.goit.tenthmodule;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Throwable {
        System.out.println("HELLO! This program creates a new file and implements load/save Shakespearean sonnet to the file\n " +
                "with advanced encryption/decryption!\n" +
                "If you need to create a new file, please, choose FILE or enter OUT for exit: ");

        Scanner in = new Scanner(System.in);
        String s = in.next();
        String sonnet  = "My mistress' eyes are nothing like the sun;\n" +
                "Coral is far more red than her lips' red;\n" +
                "If snow be white, why then her breasts are dun;\n" +
                "If hairs be wires, black wires grow on her head.\n" +
                "I have seen roses damasked, red and white,\n" +
                "But no such roses see I in her cheeks,\n" +
                "And in some perfumes is there more delight\n" +
                "Than in the breath that from my mistress reeks.\n" +
                "I love to hear her speak, yet well I know\n" +
                "That music hath a far more pleasing sound;\n" +
                "I grant I never saw a goddess go -\n" +
                "My mistress when she walks treads on the ground.\n" +
                "And yet, by heaven, I think my love as rare\n" +
                "As any she belied with false compare.";

        try {
            if (s.equals("FILE")) {
                String fileName = "goIT.txt";
                String directory = System.getProperty("myDocument");

                File file = new File(directory, fileName);

                System.out.println("Path to the file: " + file.getAbsolutePath());
                if (file.createNewFile()) {
                    System.out.println("New file is created!");
                } else {
                    System.out.println("File already exists!");
                }

                PrintWriter out = new PrintWriter(file.getAbsoluteFile());
                CaesarCode caesarCode = new CaesarCode();

                try {
                    out.print(sonnet);
                } finally {
                    out.close();
                }

                String encryptSonnet = caesarCode.encrypt(sonnet, 8);
                String decryptSonnet = caesarCode.decrypt(sonnet, 6);

                System.out.println(encryptSonnet + " \n" + decryptSonnet);

            } else if (s.equals("OUT")) {
                System.exit(1);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}