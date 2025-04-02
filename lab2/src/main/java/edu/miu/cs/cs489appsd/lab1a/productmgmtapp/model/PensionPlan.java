package edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model;

import java.time.LocalDate;

public class PensionPlan {
    private String referenceId;
    private LocalDate startDate;
    private double contributionAmount;

    // Constructor
    public PensionPlan(String referenceId, LocalDate startDate, double contributionAmount) {
        this.referenceId = referenceId;
        this.startDate = startDate;
        this.contributionAmount = contributionAmount;
    }

    // Getters and setters
    public String getReferenceId() {
        return referenceId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public double getContributionAmount() {
        return contributionAmount;
    }
}