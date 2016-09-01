package ua.goit.tenthmodule;

import java.io.File;
import java.io.IOException;

public class FileEditor {
    public String textEntry() {
        System.out.println("Enter a text message to encryption and recording to the file: ");
        String message = ScannerUtil.readString();

        if (message.isEmpty()) {
            System.out.println("Your message is empty! Try again!");
        }
        return message;
    }

    public String fileCreator(String text) throws IOException {
        System.out.println("Enter file's name to recording text message to the file: ");
        String fileName = ScannerUtil.readString();

        char[] chars = text.toCharArray();

        for (char c : chars) {
            if (!Character.isAlphabetic(c)) {
                System.out.println("Make sure you enter only letters!");
            }
        }

        File file = new File(text);

        if (file.createNewFile()) {
            System.out.println("New file is created!");
        } else {
            System.out.println("File already exists!");
        }
        return fileName.concat(".txt");
    }

    public int encryptKey() {
        System.out.println("Enter an offset value for encrypting: ");
        int keyEncrypt = ScannerUtil.readNumber();

        return keyEncrypt;
    }

    public String fileNameEntry() {
        System.out.println("Enter file's name to reading text message: ");
        String fileName = ScannerUtil.readString();

        return fileName.concat(".txt");
    }

    public int decryptKey() {
        System.out.println("Enter an offset value for decrypting: ");
        int keyDecrypt = ScannerUtil.readNumber();

        return keyDecrypt;
    }
}
