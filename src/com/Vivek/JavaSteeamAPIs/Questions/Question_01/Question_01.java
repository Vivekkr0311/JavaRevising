package com.Vivek.JavaSteeamAPIs.Questions.Question_01;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

/**
 *
 * Here’s a coding question to practice Java Streams:
 * Problem:
 * You are given a list of employees, where each employee has the following attributes:
 * id, name, department, and salary.
 * Write code using Java Streams to solve the following:
 * Find the average salary of employees in the "IT" department.
 * Get a list of names of employees whose salary is greater than 50,000.
 * Group the employees by their department.
 * Find the employee with the highest salary.
 * Count the number of employees in each department.
 */

public class Question_01 {
    /**
     * These below are solutions
     */
    private static void findAverage(List<Employee> employees){
        List<Double> salariesOfIt = employees
                .stream()
                .filter(employee -> employee.getDepartment().equals("IT"))
                .map(employee -> employee.getSalary())
                .toList();

        if(salariesOfIt.isEmpty()){
            System.out.println("Average salary: " + 0.0);
        }

        Double averageSalaryIt = salariesOfIt
                .stream()
                .reduce(0.0, (x, y) -> x + y);

        Double averageSalary = averageSalaryIt / salariesOfIt.size();
        System.out.println("Average salary: " + averageSalary);
    }

    private static void employeeName(List<Employee> employees){
        List<Employee> employeeListWhoseSalaryMoreThan50_K = employees
                .stream()
                .filter(employee -> employee.getSalary() > 50000.00)
                .toList();

       employeeListWhoseSalaryMoreThan50_K
               .stream()
               .forEach(employee -> System.out.println(employee));
    }

    private static void groupByTheirDepartments(List<Employee> employees){
        Map<String, List<Employee>> employeeMap = employees
                .stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment)

                );

        System.out.println(employeeMap);
    }

    private static void employeeWithHighestSalary(List<Employee> employees){
        Employee employeeWithMaxSalary = employees
                .stream()
                .max((e1, e2) -> ((int)e1.getSalary() - (int)e2.getSalary())).get();
        System.out.println(employeeWithMaxSalary);
    }

    private static void countNumberOfEmployeesInEachDepartment(List<Employee> employees){
        Map<String, Long> numberOfEmployeeInEachDepartment = employees
                .stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment, Collectors.counting())
                );
        System.out.println(numberOfEmployeeInEachDepartment);
    }

    /**
     * This is just to get the data for solving the question
     */
    private static List<Employee> getPopulatedList(){
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "IT", 60000),
                new Employee(2, "Bob", "HR", 45000),
                new Employee(3, "Charlie", "IT", 55000),
                new Employee(4, "Diana", "Finance", 70000),
                new Employee(5, "Eve", "IT", 40000)
        );
        return employees;
    }


    public static void main(String[] args) {
        List<Employee> employees = getPopulatedList();

        findAverage(employees);
        employeeName(employees);
        groupByTheirDepartments(employees);
        employeeWithHighestSalary(employees);
        countNumberOfEmployeesInEachDepartment(employees);
    }
}
