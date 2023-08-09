package org.example.Task3;

public class Word {
    private String word;
    private int count = 1;

    public Word(String word) {
        this.word = word;
    }

    public void increaseCount(){
        this.count++;
    }

    public int getCount() {
        return count;
    }

    public String getWord() {
        return word;
    }

    @Override
    public String toString() {
        return  word + "     " + count;
    }
}
