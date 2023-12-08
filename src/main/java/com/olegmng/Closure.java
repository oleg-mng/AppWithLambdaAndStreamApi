package com.olegmng;

import java.io.PrintStream;
import java.util.function.Consumer;

public class Closure {
    private static java.io.PrintStream PrintStream;

    public static void main(String[] args) {
        Runnable runnable = xPrinter();
        runnable.run();

        Consumer<String> lambda = objects -> System.out.println(objects);
        Consumer<String> referenceMethod = System.out::println;
//        System.setOut(new PrintStream());
        referenceMethod.accept("123");
        lambda.accept("123");
    }
    private static Runnable xPrinter() {
        final int x = 5;
        final int[] xx = new int[10];

        MethReference.Person person = new MethReference.Person("Cliff");
        person.setName("Owner");
        System.out.println(person.toString());

        xx[0] = 5;

        Runnable runnable = () -> {
            System.out.println(xx[0]);
        };
        xx[0] = 7;

        return runnable;
    }

}
