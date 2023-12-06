package com.olegmng;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

//        PlainInterface plainInterface = new PlainInterface() {
//            @Override
//            public String action(int x, int y) {
//                return String.valueOf(x + y);
//            }
//        };

        //Lambda expressions
        // вариант записи в одну строку
        PlainInterface plainInterface = (x, y) -> String.valueOf(x + y);

        // вариант записи в несколько строк
        PlainInterface plainInterface1 = (x, y) -> {
            int k = 3 + 11;
            return String.valueOf(x + y);
        };

        PlainInterface plainInterface2 = (x, y) -> String.valueOf(Integer.compare(x, y));

        PlainInterfaceInt plainInterfaceInt = Integer::compare;

        System.out.println(plainInterface.action(5, 3));
        System.out.println(plainInterface.action(11, 3));
        System.out.println(plainInterface2.action(1, 5));

        System.out.println(plainInterfaceInt.action(5, 4));

        //Stream Api use
        List<String> list = Arrays.asList("it", "golden", "some", "future", "key", "!");

        //перезапись stream в лист
        list = list.stream().filter(str -> str.length() > 4).collect(Collectors.toList());
        for (String s : list) {
            System.out.println(s);
        }

        list.stream().filter(str -> str.length() > 4).filter(str -> str.contains("tu")).forEach(System.out::println);

        Arrays.asList(1, 10, 0, 7, 5).stream().sorted().distinct().forEach(System.out::println);

        System.out.println(Arrays.asList(1, 10, 0, 7, 5).stream().sorted().findFirst().get());

        //создадим коллекцию Users
        List<User> listUsers = Arrays.asList(new User("Lazuli", 45),
                new User("Claudio", 27),
                new User("PedroM", 35));

        listUsers.stream().map(user -> new User(user.name, user.age - 5)).filter(user -> user.age<=35).
                forEach(System.out::println);

        MyInterface myInterface = it -> System.out.println(it);

        myInterface.foo("abed");

    }
}