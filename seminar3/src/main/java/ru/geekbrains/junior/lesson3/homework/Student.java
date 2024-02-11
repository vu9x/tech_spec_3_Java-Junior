package ru.geekbrains.junior.lesson3.homework;

import java.io.Serializable;

// Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
public class Student implements Serializable {

    /**
     * Fieds
     */
    String name;
    int age;
    transient double GPA;

    public Student(){}

    /**
     *
     * @param name - student name
     * @param age - student age
     * @param GPA - student gpa
     */
    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGPA() {
        return GPA;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", GPA=" + GPA +
                '}';
    }
}
