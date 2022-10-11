package com.hotelapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
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
public class Hotel {

    /**
     * This class contains all the variables of a hotel's characteristics
     */

    @Id
    @GeneratedValue(generator = "hotel_generator",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "hotel_generator",sequenceName = "hotel_sequence",initialValue = 101,allocationSize = 1)
    @ToString.Exclude
    private Integer hotelId;
    @Column(length = 30)
    private String hotelName;
    private long phone;
    private Integer noOfRooms;
    private float ratings;
    private String starRatings;
    private String propertyType;
    private String hotelImg;

    /**
     * One hotel has many rooms
     */
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "hotel")
    private List<Rooms> rooms;

    /**
     * Different hotels have different facilities
     */
    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(name = "hotel_facilities",
            joinColumns=@JoinColumn(name="hotel_id"),
            inverseJoinColumns = @JoinColumn(name="facility_id"))
    private Set<Facilities> facilities;

    /**
     * A hotel has a unique address
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    /**
     * Different hotels has many customers
     */
    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER,mappedBy = "hotels")
    private Set<Customer> customers;

    /**
     * A hotel can have many bookings at a time
     */
    @OneToMany(cascade = CascadeType.MERGE,mappedBy = "hotel")
    @JsonIgnore
    private Set<Booking> bookings;

    public Hotel(String hotelName, long phone, Integer noOfRooms, float ratings, String starRatings, String propertyType, List<Rooms> rooms, Set<Facilities> facilities, Address address) {
        this.hotelName = hotelName;
        this.phone = phone;
        this.noOfRooms = noOfRooms;
        this.ratings = ratings;
        this.starRatings = starRatings;
        this.propertyType = propertyType;
        this.rooms = rooms;
        this.facilities = facilities;
        this.address = address;

    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", phone=" + phone +
                ", noOfRooms=" + noOfRooms +
                ", ratings=" + ratings +
                ", starRatings='" + starRatings + '\'' +
                ", propertyType='" + propertyType + '\'' +
                ", rooms=" + rooms +
                ", facilities=" + facilities +
                ", address=" + address +
                '}';
    }
}
