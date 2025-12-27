package com.training.project.rideapp.service;

import com.training.project.rideapp.model.Driver;
import com.training.project.rideapp.model.Ride;
import com.training.project.rideapp.repo.RideRepo;

import java.time.LocalDateTime;
import java.util.List;

public class RideService {

    private final RideRepo rideRepository = new RideRepo();
    private final FareService fareService = new FareService();

    public void requestRide(Ride ride) {
        double fare = fareService.calculateFare(ride.getDistance());
        ride.setFare(fare);
        ride.setStatus("REQUESTED");
        rideRepository.save(ride);
    }

    public List<Ride> getAvailableRides() {
        return rideRepository.findByStatus("REQUESTED");
    }

    public void acceptRide(Ride ride, Driver driver) {
        ride.setDriver(driver);
        ride.setStatus("ACCEPTED");
        ride.setStartTime(LocalDateTime.now());
        rideRepository.update(ride);
    }

    public void completeRide(Ride ride) {
        ride.setStatus("COMPLETED");
        ride.setEndTime(LocalDateTime.now());
        rideRepository.update(ride);
    }

    public void cancelRide(Ride ride) {
        ride.setStatus("CANCELLED");
        rideRepository.update(ride);
    }
}
