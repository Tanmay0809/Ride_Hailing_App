package com.training.project.rideapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer extends User {

    @Column(nullable = false)
    private String preferredPaymentMethod;

    public Customer() {
        this.setRole("CUSTOMER");
    }

    public String getPreferredPaymentMethod() {
        return preferredPaymentMethod;
    }

    public void setPreferredPaymentMethod(String preferredPaymentMethod) {
        this.preferredPaymentMethod = preferredPaymentMethod;
    }
}
