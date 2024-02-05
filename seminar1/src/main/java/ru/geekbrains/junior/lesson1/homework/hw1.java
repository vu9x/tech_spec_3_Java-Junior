package ru.geekbrains.junior.lesson1.homework;

import java.util.stream.Stream;

public class hw1 {
    public static void main(String[] args) {
        Double answer = Stream.of(1,2,3,5,6,2,6,8,10)
                .filter(number -> number % 2 == 0)
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);

        System.out.println(answer);
    }
}
