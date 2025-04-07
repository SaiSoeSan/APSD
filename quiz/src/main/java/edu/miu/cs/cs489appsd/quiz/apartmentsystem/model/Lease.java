package edu.miu.cs.cs489appsd.quiz.apartmentsystem.model;

import java.time.LocalDate;

public class Lease {
    private Long leaseNo;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double monthlyRentalRate;
    private String tenant;
    private Apartment apartment;

    public Lease(Long leaseNo, LocalDate startDate, LocalDate endDate, Double monthlyRentalRate, String tenant, Apartment apartment) {
        this.leaseNo = leaseNo;
        this.startDate = startDate;
        this.endDate = endDate;
        this.monthlyRentalRate = monthlyRentalRate;
        this.tenant = tenant;
        this.apartment = apartment;
    }

    public Long getLeaseNo() {
        return leaseNo;
    }
    public void setLeaseNo(Long leaseNo) {
        this.leaseNo = leaseNo;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public Double getMonthlyRentalRate() {
        return monthlyRentalRate;
    }
    public void setMonthlyRentalRate(Double monthlyRentalRate) {
        this.monthlyRentalRate = monthlyRentalRate;
    }
    public String getTenant() {
        return tenant;
    }
    public void setTenant(String tenant) {
        this.tenant = tenant;
    }
}
