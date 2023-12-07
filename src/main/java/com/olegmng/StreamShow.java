package com.olegmng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamShow {
    public static void main(String[] args) {
        List<Product> productList = generateListProducts();
        productList.stream()
                .filter(product -> product.getCategory().equals("Электроника"))
                .filter(product -> product.getCost() < 10_000)
                .forEach(System.out::println);

        productList.stream()
                .filter(it -> it.getCategory().equals("Продукты"))
                .peek(it -> it.setCost(it.getCost()* 1.05))
                .forEach(System.out::println);

        List<Product> existingCollection = new ArrayList<>();

        productList.stream()
                .filter(it -> it.getName().startsWith("В"))
                .collect(Collectors.toCollection(()->existingCollection))
                .forEach(System.out::println);

        Optional<Product> optionalProduct = productList.stream()
                .filter(it -> it.getName().startsWith("Ы"))
                .findFirst();

        optionalProduct.ifPresent(it-> System.out.println(it));

        optionalProduct.ifPresentOrElse(it-> System.out.println(it), ()-> System.out.println("Объекта нет"));




    }

    private static List<Product> generateListProducts() {
        return List.of(
                new Product("Молоко", 70, "Продукты"),
                new Product("Хлеб", 120, "Продукты"),
                new Product("Вода", 80, "Продукты"),
                new Product("Чипсы", 190, "Продукты"),
                new Product("Макароны", 120, "Продукты"),

                new Product("Компьютер", 70_000, "Электроника"),
                new Product("Наушники", 10_000, "Электроника"),
                new Product("Клавиатура", 4_000, "Электроника"),

                new Product("Глицин", 150, "Лекарства"),
                new Product("Парацетамол", 120, "Лекарства"),
                new Product("Бинт", 30, "Лекарства"),
                new Product("Маска", 15, "Лекарства")
        );
    }

    static class Product {
        private final String name;
        private double cost;
        private String category;

        public Product(String name, double cost, String category) {
            this.name = name;
            this.cost = cost;
            this.category = category;
        }

        public String getName() {
            return name;
        }

        public double getCost() {
            return cost;
        }

        public String getCategory() {
            return category;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        @Override
        public String toString() {
            return String.format("[%s], (cost = %s, category = %s)", name, cost, category);
        }

    }

}
