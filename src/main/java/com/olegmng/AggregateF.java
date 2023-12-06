package com.olegmng;

// * 1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000
//   * 1.1 Найти максимальное
//   * 2.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
//   * 2.3 Найти количество чисел, квадрат которых меньше, чем 100_000

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        System.out.println(getListI());

        getListI().stream().filter(it -> it > 500_000).map(it -> it * 5 - 150).forEach(System.out::println);
    }
}