package ru.geekbrains.junior.lesson3.homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.sql.SQLOutput;

public class Deserializer {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();
    public static void binDeserializer(String fileName) throws IOException, ClassNotFoundException {
        try(FileInputStream fileInput = new FileInputStream(fileName);
                ObjectInputStream in = new ObjectInputStream(fileInput))
        {
            Student student = (Student) in.readObject();
            System.out.println("BIN Deseriazer: " + student.toString());
        }
    }

    public static void jsonDeserializer(String fileName) throws IOException {
        File file = new File(fileName);
        Student student = objectMapper.readValue(file, Student.class);
        System.out.println("JSON Deseriazer: " + student.toString());
    }

    public static void xmlDeserializer(String fileName) throws IOException {
        File file = new File(fileName);
        Student student = xmlMapper.readValue(file, Student.class);
        System.out.println("XML Deseriazer: " + student.toString());
    }
}
