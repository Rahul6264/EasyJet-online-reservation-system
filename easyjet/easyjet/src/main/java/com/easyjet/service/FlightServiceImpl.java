package com.easyjet.service;



import com.easyjet.entity.Flight;
import com.easyjet.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }


    @Override
    public Flight addFlight(Flight flight) {
        flightRepository.save(flight);
        return flight;
    }
    @Override
    public List<Flight> searchFlights(String leavingFrom, String goingTo, LocalDate departureDate, LocalDate arrivalDate) {
        return flightRepository.findByLeavingFromAndGoingToAndDepartureDateAndArrivalDate(leavingFrom, goingTo, departureDate, arrivalDate);
    }
}

