package ru.geekbrains.junior.lesson3.homework;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.*;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


public class Serializer implements Serializable {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();

    public static void binSerializer(Student student, String fileName) throws IOException {
        try(FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut))
        {
            out.writeObject(student);
            System.out.println("Объект student сериализован бинарным способом.");
        }
    }

    public static void jsonSerializer(Student student, String fileName) throws IOException {
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.writeValue(new File(fileName), student);
        System.out.println("Объект student сериализован JSON способом.");
    }

    public static void xmlSerializer(Student student, String fileName) throws IOException {
        xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        xmlMapper.writeValue(new File(fileName), student);
        System.out.println("Объект student сериализован XML способом.");
    }

}
