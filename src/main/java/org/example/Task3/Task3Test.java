package org.example.Task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Task3Test {
    public static void main(String[] args) {
        File fileToRead = new File("./src/files/words.txt");
        wordCounter(fileToRead);
    }

    public static ArrayList<String> readFile(File file) {
        ArrayList<String> res = new ArrayList();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                for (String str : scanner.nextLine().split(" ")
                ) {
                    res.add(str);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public static void wordCounter(File fileToRead) {

        ArrayList<String> words = readFile(fileToRead);
        List<Word> wordList = new ArrayList<>();
        Comparator<Word> comparator
                = (c1, c2) -> (int) (c1.getCount() - c2.getCount());
        boolean wordIsUniqe = true;
        wordList.add(new Word(words.get(0)));
        for (String word : words
        ) {
            wordIsUniqe = true;
            for (int i = 1; i < wordList.size(); i++
            ) {
                if (word.equals(wordList.get(i).getWord())) {
                    wordIsUniqe = false;
                    wordList.get(i).increaseCount();
                }
            }
            if (wordIsUniqe) {
                wordList.add(new Word(word));
            }
        }
        wordList.sort(comparator);
        for (int i = wordList.size()-1; i > -1;i--){
            System.out.println(wordList.get(i));
        }
    }

}
