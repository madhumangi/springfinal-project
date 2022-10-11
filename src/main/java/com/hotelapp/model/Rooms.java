package com.hotelapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
/**
 * @author Madhu Shree Mangi
 * @date : 16-05-2022
 * @project : SpringFinalProject
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Rooms {
    /**
     * This class stores the details of different rooms in a hotel
     */
    @Id
    @GeneratedValue(generator = "rooms_generator",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "rooms_generator",sequenceName = "rooms_sequence",initialValue = 101,allocationSize = 1)
    @ToString.Exclude
    private Integer roomNo;
    private String roomType;
    private double pricePerDay;

    /**
     * Many types of rooms are there in one hotel
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    @JsonIgnore
    private Hotel hotel;

    @OneToOne(cascade = CascadeType.MERGE,mappedBy = "room")
    @JsonIgnore
    private Booking booking;

    public Rooms(String roomType, double pricePerDay, Hotel hotel) {
        this.roomType = roomType;
        this.pricePerDay = pricePerDay;
        this.hotel = hotel;
    }
}
