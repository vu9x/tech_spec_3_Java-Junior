package org.example;

import java.io.*;

public class MainReadStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fileOutputStream = new FileInputStream("ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileOutputStream);
        String s = (String) objectInputStream.readObject();
        System.out.println(s);

    }
}
