package com.olegmng;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethReference {
    public static void main(String[] args) {
        Runnable runnable = MethReference::printNumberRandomLess100;
        runnable.run();

        List<String> listM = Arrays.asList("java", "c#", "c++", "python", "kotlin", "perl", "pascal");
        listM.sort(MethReference::bestComparator);
        System.out.println("list after reverse sort myBestComparator" + listM);

        Function<String, Integer> stringStringFunction = MethReference::stringLengthExtractor;
        System.out.println("Func: " + stringStringFunction.apply("tyuRT"));

        Function<String, Integer> unaryString = String::length;
        System.out.println(unaryString.apply("UNARYlength"));

        Supplier<Integer> supplier = "java"::length;
        System.out.println("FISupplier: " + supplier.get());

        Predicate<String> isBestProgramLanguage = "java"::equals;
        System.out.println("predicate return: " + isBestProgramLanguage.test("java"));
        System.out.println("predicate return: " + isBestProgramLanguage.test("c#"));

        Supplier<Person> personGenerator = Person::new;
        System.out.println(personGenerator.get());
        System.out.println(personGenerator.get());

    }

    static void printNumberRandomLess100() {
        System.out.println("number Random less 100: " + ThreadLocalRandom.current().nextInt(100));

    }

    static int bestComparator(String a, String b) {
        return b.length() - a.length();

    }

    static int stringLengthExtractor(String str) {
        return str.length();

    }

    public static class Person {
        private static long counter = 1L;
        private String name;

        public Person() {
            name = "Person #" + counter++;
        }

        @Override
        public String toString() {
            return "Person{" +
                   "name='" + name + '\'' +
                   '}';
        }
    }
}
