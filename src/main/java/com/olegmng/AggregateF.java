package com.olegmng;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.concurrent.ThreadLocalRandom.current;

public class AggregateF {
    static Random random = new Random();
    static List<Integer> listI = new ArrayList<>();

    public static List<Integer> getListI() {
        for (int i = 0; i < 1_000; i++) {
            int num = random.nextInt(0, 1_000_000);
            listI.add(num);

        }
        return listI;

    }

    public static List<Integer> getStreamListI() {
        List<Integer> listStream = Stream.generate(()-> ThreadLocalRandom.current().nextInt(1_000_000))
                .limit(1_000)
                .toList();

        return listStream;

    }

    public static void main(String[] args) {

        //Находим максимальное
        System.out.println("max: " + getListI().stream().max(Integer::compare).get());

        //Все числа, больше чем 500_000, умножаем на 5, вычитаем от них 150 и суммировать
        System.out.println("sum: " + getListI().stream().filter(it -> it > 500_000).
                map(it -> it * 5 - 150).mapToInt(Integer::intValue).sum());

        //Находим в потоке количество чисел, квадрат которых меньше, чем 100_000
        System.out.println("count: " + getListI().stream().map(it -> it * it).
                filter(it -> it < 100_000).count());

        System.out.println("sum from listStream: " + getListI().stream().filter(it -> it > 500_000).
                map(it -> it * 5 - 150).reduce(0, (a, b) -> a + b));

        //interface Runnable
        System.out.print("\nRunnable, run(): ");
        Runnable runnable = () -> System.out.print(current().nextInt(111) + " ");
        for (int i = 0; i < 7; i++) {
            runnable.run();
        }
        //interface Supplier
        Supplier supplier = () -> 5;
        System.out.print("\nSupplier, get(): " + supplier.get());

        //interface Function
        Function<String, Integer> stringIntegerFunction = arg -> arg.length();
        System.out.print("\nFunction, apply(): " + stringIntegerFunction.apply("jcnucenwu"));

        Function<String, String> stringFunction = it -> it.trim();
        System.out.print("\nFunction, apply(): " + stringFunction.apply("    jcnTTTenwu   "));

    }
}
