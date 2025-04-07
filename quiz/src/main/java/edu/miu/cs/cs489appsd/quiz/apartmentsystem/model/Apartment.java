package edu.miu.cs.cs489appsd.quiz.apartmentsystem.model;

import java.util.ArrayList;
import java.util.List;

public class Apartment {
    private String apartmentNo;
    private String propertyName;
    private int floorNo;
    private double size;
    private int numberOfRooms;
    //list of leases
    private List<Lease> leases = new ArrayList<>();


    public Apartment(String apartmentNo, String propertyName, int floorNo, double size, int numberOfRooms) {
        this.apartmentNo = apartmentNo;
        this.propertyName = propertyName;
        this.floorNo = floorNo;
        this.size = size;
        this.numberOfRooms = numberOfRooms;
    }
//    public Apartment(String apartmentNo, String propertyName, int floorNo, double size, int numberOfRooms, List<Lease> leases) {
//        this.apartmentNo = apartmentNo;
//        this.propertyName = propertyName;
//        this.floorNo = floorNo;
//        this.size = size;
//        this.numberOfRooms = numberOfRooms;
//        this.leases = leases;
//    }
    public String getApartmentNo() {
        return apartmentNo;
    }
    public void setApartmentNo(String apartmentNo) {
        this.apartmentNo = apartmentNo;
    }
    public String getPropertyName() {
        return propertyName;
    }
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
    public int getFloorNo() {
        return floorNo;
    }
    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }
    public double getSize() {
        return size;
    }
    public void setSize(double size) {
        this.size = size;
    }
    public int getNumberOfRooms() {
        return numberOfRooms;
    }
    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public List<Lease> getLeases() {
        return leases;
    }
    public void setLeases(List<Lease> leases) {
        this.leases = leases;
    }

    public boolean hasLeases() {
        return leases != null && !leases.isEmpty();
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "apartmentNo=" + apartmentNo +
                ", propertyName='" + propertyName + '\'' +
                ", floorNo=" + floorNo +
                ", size=" + size +
                ", numberOfRooms=" + numberOfRooms +
                ", leases=" + leases +
                '}';
    }
}
