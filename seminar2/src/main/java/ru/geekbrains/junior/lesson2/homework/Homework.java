package ru.geekbrains.junior.lesson2.homework;

import ru.geekbrains.junior.lesson2.homework.animals.Animal;
import ru.geekbrains.junior.lesson2.homework.animals.Cat;
import ru.geekbrains.junior.lesson2.homework.animals.Dog;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Homework {
    /*
        + Создайте абстрактный класс "Animal" с полями "name" и "age".
        + Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
        +Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
        _Выведите на экран информацию о каждом объекте.
        _Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
     */
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String animalClass = "ru.geekbrains.junior.lesson2.homework.animals.Animal";
        String dogClass = "ru.geekbrains.junior.lesson2.homework.animals.Dog";
        String catClass = "ru.geekbrains.junior.lesson2.homework.animals.Cat";

        ArrayList<Animal> animalList = new ArrayList<>();

        Object dog1 = instanceGenerator(dogClass, "dog", 1);
        Object cat1 = instanceGenerator(catClass, "cat", 2);
        animalList.add((Dog)dog1);
        animalList.add((Cat)cat1);

        animalList.stream().forEach(Animal::makeSound);
    }

    public static Object instanceGenerator(String className, String animalName, int age) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> classObject = Class.forName(className);
        Constructor[] constructors = classObject.getConstructors();
        return constructors[0].newInstance(animalName, age);
    }
}
