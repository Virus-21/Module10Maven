package org.example.Task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1Test {

    public static void main(String[] args) throws IOException {
        File file1 = new File("./src/files/file.txt");
        numberValidation(file1);


    }

    public static void numberValidation(File file) {
        List<StringBuilder> numbers = readFile(file);
        boolean numberIsValid = true;
        String regexfor14 = "^((\\(\\d{3}\\))) \\d{3}-\\d{4}$";
        String regexfor12 = "^\\d{3}-\\d{3}-\\d{4}";
        for (StringBuilder number : numbers
        ) {
            if (number.length() == 14) {
                Pattern pattern = Pattern.compile(regexfor14);
                Matcher matcher = pattern.matcher(number);
                if (matcher.matches()) {
                    System.out.println(number);
                }

            } else if (number.length() == 12) {
                Pattern pattern = Pattern.compile(regexfor12);
                Matcher matcher = pattern.matcher(number);
                if (matcher.matches()) {
                    System.out.println(number);
                }
            }
        }
    }

    public static List<StringBuilder> readFile(File file) {
        List<StringBuilder> fileContent = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                fileContent.add(new StringBuilder(scanner.nextLine()));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return fileContent;
    }

}
