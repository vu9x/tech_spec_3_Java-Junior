package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MainWriteStream {
    public static void main(String[] args) throws IOException {
        String str = "Всем привет";
        FileOutputStream fileOutputStream = new FileOutputStream("ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(str);
        objectOutputStream.close();
//        System.out.println("Hello world!");
    }
}