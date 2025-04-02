package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Employee;
import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.PensionPlan;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PensionReport {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule()); // Register JavaTimeModule
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            List<Employee> employees = new ArrayList<>();

            // Sample employee data (adjusted for quarterly hiring periods)
            employees.add(new Employee(12345L, "John", "Doe", LocalDate.of(2015, Month.JANUARY, 10), 75000, new PensionPlan("REF123", LocalDate.of(2020, Month.JANUARY, 1), 500.0)));
            employees.add(new Employee(67890L, "Jane", "Smith", LocalDate.of(2012, Month.MARCH, 15), 85000, new PensionPlan("REF456", LocalDate.of(2019, Month.FEBRUARY, 15), 600.0)));
            employees.add(new Employee(11223L, "Alice", "Johnson", LocalDate.of(2010, Month.JUNE, 20), 95000, new PensionPlan("REF789", LocalDate.of(2018, Month.MARCH, 10), 450.0)));

            employees.add(new Employee(44556L, "Bob", "Brown", LocalDate.of(2024, Month.APRIL, 5), 55000, null)); // Hired in Q2 2024
            employees.add(new Employee(77889L, "Charlie", "Davis", LocalDate.of(2024, Month.MAY, 15), 60000, null)); // Hired in Q2 2024
            employees.add(new Employee(99001L, "Eve", "Wilson", LocalDate.of(2024, Month.JUNE, 1), 50000, null)); // Hired in Q2 2024

            employees.add(new Employee(12347L, "David", "Clark", LocalDate.of(2025, Month.JULY, 5), 65000, null));
            employees.add(new Employee(12348L, "Emily", "Stone", LocalDate.of(2025, Month.AUGUST, 10), 70000, null));
            employees.add(new Employee(12349L, "Frank", "White", LocalDate.of(2025, Month.SEPTEMBER, 20), 72000, null));

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
    }
}
