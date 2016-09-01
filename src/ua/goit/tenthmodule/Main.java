package ua.goit.tenthmodule;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        System.out.println("HELLO! This program implements save/load a text message to the file " +
                "with advanced encryption/decryption!\n" +
                "If you need to recording a text message to the file choose RECORD,\n" +
                "for reading a text message choose READ\nor enter OUT for exit: ");

        for (; ; ) {
            String choice = ScannerUtil.readString();

            try {
                switch (choice) {
                    case "RECORD":
                        FileEditor record = new FileEditor();
                        String text = record.textEntry();
                        String file = record.fileCreator(text);
                        int encryptKey = record.encryptKey();

                        String encrypt = CaesarCode.encrypt(text, encryptKey);

                        FileWriter fileWriter = new FileWriter(file);
                        fileWriter.write(encrypt);
                        fileWriter.close();
                        continueProgram();
                        break;
                    case "READ":
                        FileEditor read = new FileEditor();
                        String createdFileName = read.fileNameEntry();
                        int decryptKey = read.decryptKey();

                        FileReader fileReader = new FileReader(createdFileName);
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        text = bufferedReader.readLine();
                        bufferedReader.close();
                        fileReader.close();

                        String decrypt = CaesarCode.decrypt(text, decryptKey);
                        System.out.println(decrypt);
                        continueProgram();
                        break;
                    case "OUT":
                        System.exit(1);
                    default:
                        System.out.println("Choose RECORD or READ or enter OUT for exit: ");
                        break;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void continueProgram() {
        System.out.println("\nFor continue use this program, choose RECORD, READ or enter OUT for exit: ");
    }
}
