package com.oop.ride_booking.user;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Rider extends User {
    @NotNull 
    private long loyaltyPoints;
    
    public Rider(long id, String firstName, String lastName, String email, String phoneNumber, LocalDate dob, Gender gender, LocalDateTime createdAt, LocalDateTime updatedAt, long loyaltyPoints) {
        super(id, firstName, lastName, email, phoneNumber, dob, gender, createdAt, updatedAt);
        this.loyaltyPoints = loyaltyPoints;
    }
    public Rider(User user, long loyaltyPoints) {
        super(user);
        this.loyaltyPoints = loyaltyPoints;
    }

    public long getLoyaltyPoints() {
        return loyaltyPoints;
    }
    public void setLoyaltyPoints(long loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
}
