package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Employee;
import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.PensionPlan;

import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Main {
    private static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        // Pension Plans
        PensionPlan pensionPlan1 = new PensionPlan("REF123", LocalDate.of(2020, Month.JANUARY, 1), 500.0);
        PensionPlan pensionPlan2 = new PensionPlan("REF456", LocalDate.of(2019, Month.FEBRUARY, 15), 600.0);
        PensionPlan pensionPlan3 = new PensionPlan("REF789", LocalDate.of(2018, Month.MARCH, 10), 450.0);
        PensionPlan pensionPlan4 = new PensionPlan("REF101", LocalDate.of(2022, Month.JULY, 20), 550.0);
        PensionPlan pensionPlan5 = new PensionPlan("REF102", LocalDate.of(2021, Month.OCTOBER, 5), 650.0);

// Employees hired in each quarter with Pension Plan
        employees.add(new Employee(10001L, "Alice", "Miller", LocalDate.of(2025, Month.JANUARY, 15), 80000, pensionPlan1)); // Q1 2025
        employees.add(new Employee(10002L, "Bob", "Johnson", LocalDate.of(2025, Month.APRIL, 10), 75000, pensionPlan2)); // Q2 2025
        employees.add(new Employee(10003L, "Charlie", "Davis", LocalDate.of(2025, Month.JULY, 5), 82000, pensionPlan3)); // Q3 2025
        employees.add(new Employee(10004L, "David", "Clark", LocalDate.of(2025, Month.OCTOBER, 12), 90000, pensionPlan4)); // Q4 2025
        employees.add(new Employee(10005L, "Eve", "Wilson", LocalDate.of(2026, Month.JANUARY, 8), 87000, pensionPlan5)); // Q1 2026

        employees.add(new Employee(12347L, "David", "Clark", LocalDate.of(2025, Month.JULY, 5), 65000, null));
        employees.add(new Employee(12348L, "Emily", "Stone", LocalDate.of(2025, Month.AUGUST, 10), 70000, null));
        employees.add(new Employee(12349L, "Frank", "White", LocalDate.of(2025, Month.SEPTEMBER, 20), 72000, null));

        Main app = new Main();
        app.printAllEmployeesWithPensionInJson(employees);
        app.printQuarterlyUpcomingEnrolleesReport(employees);
    }

    public void printAllEmployeesWithPensionInJson(List<Employee> employees) {
        System.out.println ("Employees with PensionPlan");
        System.out.println ("=====================================");
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule()); // Register JavaTimeModule
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            List<Employee> sortedEmployees = employees.stream()
                    .sorted(Comparator.comparing(Employee::getYearlySalary).reversed()
                            .thenComparing(Employee::getLastName))
                    .collect(Collectors.toList());

            String jsonOutput = objectMapper.writeValueAsString(sortedEmployees);
            System.out.println(jsonOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printQuarterlyUpcomingEnrolleesReport(List<Employee> employees) {
        System.out.println("Quarterly Upcoming Enrollees Report");
        System.out.println("=====================================");
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule()); // Register JavaTimeModule
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            LocalDate now = LocalDate.now();

            // Determine the next quarter start and end
            int currentQuarter = (now.getMonthValue() - 1) / 3 + 1;
            int nextQuarter = currentQuarter + 1;
            int nextQuarterStartMonth = (nextQuarter - 1) * 3 + 1;
            int year = now.getYear();
            if (nextQuarterStartMonth > 12) {
                nextQuarterStartMonth = 1;
                year += 1;
            }

            LocalDate firstDayOfNextQuarter = LocalDate.of(year, nextQuarterStartMonth, 1);
            LocalDate lastDayOfNextQuarter = firstDayOfNextQuarter.plusMonths(2).withDayOfMonth(firstDayOfNextQuarter.plusMonths(2).lengthOfMonth());

            // Debugging logs
            System.out.println("Next Quarter Start: " + firstDayOfNextQuarter);
            System.out.println("Next Quarter End: " + lastDayOfNextQuarter);

            // Filtering employees hired within the next quarter
            List<Employee> upcomingEnrollees = employees.stream()
                    .filter(emp -> emp.getEmploymentDate() != null &&
                            !emp.isEnrolledInPension() &&
                            !emp.getEmploymentDate().isBefore(firstDayOfNextQuarter) &&
                            !emp.getEmploymentDate().isAfter(lastDayOfNextQuarter))
                    .sorted(Comparator.comparing(Employee::getEmploymentDate))
                    .collect(Collectors.toList());

            // Output result
            String jsonOutput = objectMapper.writeValueAsString(upcomingEnrollees);
            System.out.println(jsonOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            objectMapper.registerModule(new JavaTimeModule()); // Register JavaTimeModule
//            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
//
//            LocalDate now = LocalDate.now();
//            LocalDate firstDayOfNextQuarter = now.withMonth(((now.getMonthValue() - 1) / 3 + 1) * 3 + 1).withDayOfMonth(1);
//            LocalDate lastDayOfNextQuarter = firstDayOfNextQuarter.plusMonths(2).withDayOfMonth(firstDayOfNextQuarter.plusMonths(2).lengthOfMonth());
//
//            List<Employee> upcomingEnrollees = employees.stream()
//                    .filter(emp -> !emp.isEnrolledInPension() &&
//                            emp.getEmploymentDate().isAfter(firstDayOfNextQuarter.minusDays(1)) &&
//                            emp.getEmploymentDate().isBefore(lastDayOfNextQuarter.plusDays(1)))
//                    .sorted(Comparator.comparing(Employee::getEmploymentDate).reversed())
//                    .collect(Collectors.toList());
//
//            String jsonOutput = objectMapper.writeValueAsString(upcomingEnrollees);
//            System.out.println(jsonOutput);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}