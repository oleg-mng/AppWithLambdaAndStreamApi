package com.olegmng;

// * 1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000
//   * 1.1 Найти максимальное
//   * 2.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
//   * 2.3 Найти количество чисел, квадрат которых меньше, чем 100_000

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.function.Supplier;

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

    public static void main(String[] args) {

        System.out.println("max: " + getListI().stream().max(Integer::compare).get());

        System.out.println("sum: " + getListI().stream().filter(it -> it > 500_000).
                map(it -> it * 5 - 150).mapToInt(Integer::intValue).sum());

        System.out.print("count: " + getListI().stream().map(it -> it * it).
                filter(it -> it < 100_000).count());

        //interface Runnable
        System.out.print("\nRunnable, run(): ");
        Runnable runnable = () -> System.out.print(ThreadLocalRandom.current().nextInt(111) + " ");
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
