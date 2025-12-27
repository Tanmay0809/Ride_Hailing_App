package com.training.project.rideapp.model;

import jakarta.persistence.*;


@Entity
@Table(name = "drivers")
public class Driver extends User {

    @Column(nullable = false, unique = true)
    private String licenseNumber;

    @Column(nullable = false)
    private boolean available;

    public Driver() {
        this.setRole("DRIVER");
        this.available = true;
    }

    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}
