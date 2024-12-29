package com.easyjet.controller;


import com.easyjet.entity.Flight;
import com.easyjet.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping
    public ResponseEntity<String> addFlight(@RequestBody Flight flight) {
        Flight savedFlight = flightService.addFlight(flight);
        String message = "Flight added successfully with ID: " + savedFlight.getId();
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }


    @GetMapping("/search")
    public ResponseEntity<List<Flight>> searchFlights(
            @RequestParam("leaving_from") String leavingFrom,
            @RequestParam("going_to") String goingTo,
            @RequestParam("departure_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate,
            @RequestParam("arrival_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate arrivalDate) {

        List<Flight> flights;
        flights = flightService.searchFlights(leavingFrom, goingTo, arrivalDate, departureDate);
        if (!flights.isEmpty()) {
            return new ResponseEntity<>(flights, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
