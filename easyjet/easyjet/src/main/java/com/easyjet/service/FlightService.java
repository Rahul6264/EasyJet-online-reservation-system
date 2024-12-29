package com.easyjet.service;

import com.easyjet.entity.Flight;

import java.time.LocalDate;
import java.util.List;

public interface FlightService {

    Flight addFlight(Flight flight);
    List<Flight> searchFlights(String departureDate, String goingTo, LocalDate arrivalDate, LocalDate leavingFrom);
}
