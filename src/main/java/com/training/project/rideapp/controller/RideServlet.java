package com.training.project.rideapp.controller;

import com.training.project.rideapp.model.Customer;
import com.training.project.rideapp.model.Driver;
import com.training.project.rideapp.model.Ride;
import com.training.project.rideapp.service.RideService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/ride")
public class RideServlet extends HttpServlet {

    private final RideService rideService = new RideService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        Ride ride = (Ride) session.getAttribute("ride");

        if ("REQUEST".equals(action)) {
            Customer customer = (Customer) session.getAttribute("loggedInUser");

            Ride newRide = new Ride();
            newRide.setPickupLocation(request.getParameter("pickup"));
            newRide.setDropLocation(request.getParameter("drop"));
            newRide.setDistance(Double.parseDouble(request.getParameter("distance")));
            newRide.setCustomer(customer);

            rideService.requestRide(newRide);
            session.setAttribute("ride", newRide);

        } else if ("ACCEPT".equals(action)) {
            Driver driver = (Driver) session.getAttribute("loggedInUser");
            rideService.acceptRide(ride, driver);

        } else if ("COMPLETE".equals(action)) {
            rideService.completeRide(ride);

        } else if ("CANCEL".equals(action)) {
            rideService.cancelRide(ride);
        }

        response.sendRedirect("jsp/dashboard.jsp");
    }
}
