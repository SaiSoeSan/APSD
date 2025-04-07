package edu.miu.cs.cs489appsd.quiz.apartmentsystem;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import edu.miu.cs.cs489appsd.quiz.apartmentsystem.model.Apartment;
import edu.miu.cs.cs489appsd.quiz.apartmentsystem.model.Lease;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //create data
        Apartment apartment = new Apartment("B1102","The Cameron House",11,790,3);
        Apartment apartment1 = new Apartment("A705","The Cameron House",7,855,4);
        Apartment apartment2 = new Apartment("C1210","Point Palace",12,1000,4);
        Apartment apartment3 = new Apartment("A1371","Point Palace",13,1000,4);


        //create leases
        Lease lease = new Lease(3128874121L,LocalDate.of(2025,2,1), LocalDate.of(2026,10,2),
                1750.50,"Michael Philips",apartment1);
        Lease lease1 = new Lease(2927458265L,LocalDate.of(2025,4,2), LocalDate.of(2025,10,2),
                1500.00,"Anna Smith",apartment);
        Lease lease2 = new Lease(9189927460L,LocalDate.of(2025,3,1), LocalDate.of(2026,3,1),
                2560.75,"Alex Campos",apartment3);
        Lease lease3 = new Lease(3128874119L,LocalDate.of(2023,2,1), LocalDate.of(2024,2,1),
                1650.55,"Michael Philips",apartment1);


        //set apartment B1102 with lease
        List<Lease> leases = new ArrayList<>();
        leases.add(lease1);
        apartment.setLeases(leases);

        //set apartment A705 with 2 leases
        List<Lease> leasesForA705 = new ArrayList<>();
        leasesForA705.add(lease);
        leasesForA705.add(lease3);
        apartment1.setLeases(leasesForA705);

        //set apartment3 with a lease
        List<Lease> leasesForA1371 = new ArrayList<>();
        leasesForA1371.add(lease2);
        apartment3.setLeases(leasesForA1371);


        //list of apartments
        List<Apartment> apartments = new ArrayList<>();
        apartments.add(apartment);
        apartments.add(apartment1);
        apartments.add(apartment2);
        apartments.add(apartment3);



        //print apartments
        Main main = new Main();
//        main.printApartments(apartments);
        main.totalRevenue(apartments);
    }

    public void printApartments(List<Apartment> apartments) {
        //print list of apartment with json
        System.out.println("List of apartments:---------");
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.registerModule(new JavaTimeModule());
        try {
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(apartments);
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void totalRevenue(List<Apartment> apartments) {
        //calculate revenue for all apartments
        double totalRevenue = 0;
        System.out.println("Total revenue for all apartments:---------");
        for (Apartment apartment : apartments) {
            double eachRevenue = 0;
            if (apartment.hasLeases()) {
                for (Lease lease : apartment.getLeases()) {
                    //calculate the number of months between start date and end date
                    int months = (int) (lease.getEndDate().toEpochDay() - lease.getStartDate().toEpochDay()) / 30;
                    eachRevenue += months * lease.getMonthlyRentalRate();
                }
                totalRevenue += eachRevenue;
            }
        }
        System.out.printf("Total revenue for all apartments is: $%,.2f%n", totalRevenue);
    }
}