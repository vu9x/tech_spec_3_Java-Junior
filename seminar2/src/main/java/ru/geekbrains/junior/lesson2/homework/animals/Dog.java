package ru.geekbrains.junior.lesson2.homework.animals;

public class Dog extends Animal{
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.printf("Dog %s, which age is %d, says woof  \n", super.getName(), super.getAge());
    }
}
