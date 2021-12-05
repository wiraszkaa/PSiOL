package com.example.jakubwiraszka.lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileEditor {

    public static boolean writeFile(String content, String path) throws FileNotFoundException {

        File file = new File(path);
        PrintWriter save = new PrintWriter(file);
        save.print(content);
        save.close();

        return true;
    }

    public static String readFile(String path) throws FileNotFoundException {

        StringBuilder message = new StringBuilder();

        File file = new File(path);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            message.append(scanner.nextLine());
            message.append("\n");
        }

        return message.toString();
    }
}
