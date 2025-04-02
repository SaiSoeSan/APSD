package edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDate;

public class Employee {
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate employmentDate;
    private double yearlySalary;

    @JsonInclude(JsonInclude.Include.NON_NULL) // Include only if not null
    private PensionPlan pensionPlan;

    // Constructor
    public Employee(long id, String firstName, String lastName, LocalDate employmentDate, double yearlySalary, PensionPlan pensionPlan) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.yearlySalary = yearlySalary;
        this.pensionPlan = pensionPlan;
    }

    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public PensionPlan getPensionPlan() {
        return pensionPlan;
    }

    public void setPensionPlan(PensionPlan pensionPlan) {
        this.pensionPlan = pensionPlan;
    }

    // toString method
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employmentDate='" + employmentDate + '\'' +
                ", yearlySalary=" + yearlySalary +
                ", pensionPlan=" + pensionPlan +
                '}';
    }

    public boolean isEnrolledInPension() {
        return pensionPlan != null;
    }
}
