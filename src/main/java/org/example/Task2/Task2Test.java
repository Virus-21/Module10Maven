package org.example.Task2;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2Test {
    public static void main(String[] args) {
        File fileToRead = new File("./src/files2/file.txt");
        jsonFileCreator(fileToRead);

    }

    public static void jsonFileCreator(File fileToRead) {
        File fileToWrite = new File("./src/files2/user.json");
        List<User> userList = fileReader(fileToRead);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(userList);
        fileWriter(fileToWrite, json);
    }

    public static List<User> fileReader(File file) {
        List<User> fileContent = new ArrayList<>();
        UserCreator userCreator = new UserCreator();
        int index = 0;
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                if (index > 0) {
                    fileContent.add(userCreator.createUser(scanner.nextLine()));
                } else {
                    scanner.nextLine();
                }
                index++;
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return fileContent;
    }

    public static void fileWriter(File file, String text) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
