package com.rideease.model;

import java.sql.Date;

public class BookingBean {
    private int id;
    private String name;
    private Date date;
    private String phoneNumber;
    private String vehicleType;
    private int passengerCount;

    public BookingBean() {}

    public BookingBean(int id, String name, Date date, String phoneNumber, String vehicleType, int passengerCount) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.vehicleType = vehicleType;
        this.passengerCount = passengerCount;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }
}