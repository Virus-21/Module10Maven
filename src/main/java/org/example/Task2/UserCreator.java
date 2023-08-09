package org.example.Task2;

public class UserCreator {
    public User createUser(String str) {
        String[] splittedString = str.split(" ");
        return new User(splittedString[0], Integer.parseInt(splittedString[1]));
    }
}
