package com.oop.ride_booking.user;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import com.oop.ride_booking.type.Point;

public class Driver extends User {
    @NotEmpty
    private String licenseNumber;

    @NotNull
    private double rating;

    @NotNull
    private boolean isAvailable;

    @NotNull
    private Point currentPoint;

    public Driver(long id, String firstName, String lastName, String email, String phoneNumber, LocalDate dob, Gender gender, LocalDateTime createdAt, LocalDateTime updatedAt, String licenseNumber, Point currentPoint) {
        super(id, firstName, lastName, email, phoneNumber, dob, gender, createdAt, updatedAt);
        this.licenseNumber = licenseNumber;
        this.currentPoint = currentPoint;
    }
    
    public Driver(User user, String licenseNumber, Point currentPoint) {
        super(user);
        this.licenseNumber = licenseNumber;
        this.currentPoint = currentPoint;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Point getCurrentPoint() {
        return currentPoint;
    }

    public void setCurrentPoint(Point currentPoint) {
        this.currentPoint = currentPoint;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
