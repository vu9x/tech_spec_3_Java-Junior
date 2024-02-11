package ru.geekbrains.junior.lesson2.homework.animals;

public class Cat extends Animal{
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.printf("Cat %s, which age is %d, says meow  \n", super.getName(), super.getAge());

    }
}
