package ru.geekbrains.junior.lesson3.homework;

import java.io.*;

public class Main {
    /*
        + Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
        + Обеспечьте поддержку сериализации для этого класса.
        + Создайте объект класса Student и инициализируйте его данными.
        + Сериализуйте этот объект в файл.
        + Десериализуйте объект обратно в программу из файла.
        + Выведите все поля объекта, включая GPA, и ответьте на вопрос,
        почему значение GPA не было сохранено/восстановлено.
     */

    private static final String BIN = "student.bin";
    private static final String JSON = "student.json";
    private static final String XML = "student.xml";


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student student = new Student("Ivan", 18, 4.5);

        //Serializer:
        Serializer.binSerializer(student, BIN);
        Serializer.jsonSerializer(student, JSON);
        Serializer.xmlSerializer(student, XML);

        //Deserializer:
        Deserializer.binDeserializer(BIN);
        Deserializer.jsonDeserializer(JSON);
        Deserializer.xmlDeserializer(XML);
    }
}
