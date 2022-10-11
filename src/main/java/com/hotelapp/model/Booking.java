package com.hotelapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
/**
 * @author Madhu Shree Mangi
 * @date : 16-05-2022
 * @project : SpringFinalProject
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Booking {
    /**
     * This class has all the variables to store the information required for booking a hotel
     */
    @Id
    @GeneratedValue(generator = "booking_generator",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "booking_generator",sequenceName = "booking_sequence",allocationSize = 1,initialValue = 1)
    @ToString.Exclude
    private Integer bookingId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private LocalDate bookingDate;
    private Integer noOfPersons;
    private double totalCost;

    /**
     * Bill for a booking
     */
    private Integer billingNo;
    @Column(length = 20)
    private String paymentMode;

    /**
     * Many bookings can be done by a single customer
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    /**
     * Many bookings can be done for a particular hotel
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    /**
     * One booking can have only one room type
     */
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "room_no")
    private Rooms room;


    public Booking(LocalDate checkInDate, LocalDate checkOutDate, LocalDate bookingDate, Integer noOfPersons, double totalCost, Integer billingNo, String paymentMode, Customer customer, Hotel hotel, Rooms room) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.bookingDate = bookingDate;
        this.noOfPersons = noOfPersons;
        this.totalCost = totalCost;
        this.billingNo = billingNo;
        this.paymentMode = paymentMode;
        this.customer = customer;
        this.hotel = hotel;
        this.room = room;
    }
}
