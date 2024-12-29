package com.easyjet.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "leaving_from")
    private String leavingFrom;

    @Column(name = "going_to")
    private String goingTo;

    @Column(name = "departure_date")
    private LocalDate departureDate;

    @Column(name = "arrival_date")
    private LocalDate arrivalDate;

    @Column(name = "traveller")
    private String traveller;

    @Column(name = "type")
    private String type;

    @Column(name = "seats")
    private int seats;

    @Column(name = "price")
    private double price;

    public Flight() {
        // Default constructor
    }

    public Flight(String leavingFrom, String goingTo, LocalDate departureDate, LocalDate arrivalDate,
                  String traveller, String type, int seats, double price) {
        this.leavingFrom = leavingFrom;
        this.goingTo = goingTo;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.traveller = traveller;
        this.type = type;
        this.seats = seats;
        this.price = price;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLeavingFrom() {
        return leavingFrom;
    }

    public void setLeavingFrom(String leavingFrom) {
        this.leavingFrom = leavingFrom;
    }

    public String getGoingTo() {
        return goingTo;
    }

    public void setGoingTo(String goingTo) {
        this.goingTo = goingTo;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getTraveller() {
        return traveller;
    }
    public void setTraveller(String traveller) {
        this.traveller = traveller;
    }
                                                
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
