package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static <StirngBuilder> void main(String[] args) {
//        PlainInterface plainInterface = new PlainInterface() {
//            @Override
//            public String action(int x, int y) {
//                return String.valueOf(x+y);
//            }
//        };

//        PlainInterface plainInterface = (x, y) -> String.valueOf(x+y);
//        PlainInterface plainInterface1 = (x, y) -> String.valueOf(Integer.compare(x, y));

//        PlainInterface plainInterface = (x, y) -> x+y;
//        PlainInterface plainInterface1 = (x, y) -> Integer.compare(x, y);

        PlainInterface plainInterface = Integer::sum;
        PlainInterface plainInterface1 = Integer::compare; // метод компэр следует рассматривать,
        // как объект. Функциональное программирование, когда методы можно присваивать в качестве
        // значений к нашим объекты
        // функциональные интерфейсы

        System.out.println(plainInterface.action(5, 3));
        System.out.println(plainInterface1.action(1, 5));


        List<String> list = Arrays.asList("Привет", "мир", "!", "я", "родился", "!");

//        list = list.stream().filter(str -> str.length() > 4).collect(Collectors.toList());
//
//        for(String item : list){
//            System.out.println(item);
//        }

        list.stream().filter(str -> str.length() > 4)
                .filter(str -> str.contains("о"))
                .forEach(System.out::println);


        // Ещё пример стрима (потока)
        Arrays.asList(1,2,3,4,5).stream().map(number -> "число: " + number + ". Квадрат числа: " + number * number)
                .forEach(System.out::println);

        // Ещё пример стрима (потока)
        Arrays.asList(10,2,13,1,5).stream().sorted().forEach(System.out::println);

        // Ещё пример стрима (потока)
        Stream.of(10,5,13,1,5).sorted().distinct().forEach(System.out::println);

        List<User> users = Arrays.asList(new User("Павел", 25), new User("Аркадий", 40), new User("Валера", 30));
        users.stream().map(user -> new User(user.name, user.age - 5)).forEach(System.out::println);

        users.stream().map(user -> new User(user.name, user.age - 5))
                .filter(user -> user.age <=25)
                .forEach(System.out::println);

        // посмотреть на class.cast(another class);

    }
}