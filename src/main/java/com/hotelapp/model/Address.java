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
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address {

    /**
     * This class has all the variables required to store the address details of a hotel or a customer
      */
    @Id
    @GeneratedValue(generator = "address_generator",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "address_generator",sequenceName = "address_sequence",allocationSize = 1,initialValue = 1001)
    @ToString.Exclude
    private Integer addressId;
    @Column(length = 30)
    private String city;
    @Column(length = 20)
    private String state;
    @Column(length = 50)
    private String properAddress;
    private Integer pinCode;

    /**
     * Customer has a unique address
     */
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "address")
    @JsonIgnore
    private Customer customer;

    /**
     * Each hotel has a unique address
     */
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "address")
    @JsonIgnore
    private Hotel hotel;

    public Address(String city, String state, String properAddress, Integer pinCode, Customer customer) {
        this.city = city;
        this.state = state;
        this.properAddress = properAddress;
        this.pinCode = pinCode;
        this.customer = customer;
    }
}
