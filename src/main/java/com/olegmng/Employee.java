package com.olegmng;

import java.util.Arrays;
import java.util.List;

// * 2. Создать класс Employee (Сотрудник) с полями: String name, int age, double salary, String department
//   * 2.1 Создать список из 10-20 сотрудников
//   * 2.2 Вывести список всех различных отделов (department) по списку сотрудников
//   * 2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
//   * 2.4 * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и
//   сотрудниками внутри отдела
//   * 2.5 * Из списка сорудников с помощью стрима создать Map<String, Double> с отделами и
//   средней зарплатой внутри отдела
public class Employee {
    String name;
    int age;
    double salary;
    String department;

    public Employee(String name, int age, double salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
               "name='" + name + '\'' +
               ", age=" + age +
               ", salary=" + salary +
               ", department='" + department + '\'' +
               '}';
    }

    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(new Employee("Grig", 37, 7_000, "IT"),
                new Employee("Max", 31, 5_000, "SALE"),
                new Employee("Elena", 23, 12_000, "BUH"),
                new Employee("Petr", 37, 35_000, "IT"),
                new Employee("Oleg", 31, 47_000, "IT"),
                new Employee("Alex", 37, 85_000, "IT"),
                new Employee("Marina", 33, 56_000, "BUH"),
                new Employee("Grig", 31, 56_000, "IT"),
                new Employee("Vika", 41, 23_000, "SALE"),
                new Employee("Vlad", 25, 97_000, "IT")
                );

        employeeList.stream().filter(employee -> employee.salary<10000).map(employee -> new Employee(employee.name, employee.age,
                employee.salary *1.2,employee.department)).forEach(System.out::println);

    }
}
