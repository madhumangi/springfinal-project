package com.hotelapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
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
@ToString
public class Customer {
    /**
     * This class contains all the variables of details of a customer
     */
    @Id
    @GeneratedValue(generator = "customer_generator",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "customer_generator",sequenceName = "customer_sequence",allocationSize = 1,initialValue = 101)
    @ToString.Exclude
    private Integer customerId;
    @Column(length = 40)
    private String customerName;
    private long mobile;
    @Column(length = 20)
    private String idProof;
    private String gender;
    @Column(length = 20)
    private String nationality;

    /**
     * Customer has a unique address
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    /**
     * A particular customer can do many bookings
     */
    @OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER,mappedBy = "customer")
    @JsonIgnore
    private Set<Booking> bookings;

    /**
     * A customer can view many hotel's details
     */
    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(name = "hotel_customers",
            joinColumns=@JoinColumn(name="hotel_id"),
            inverseJoinColumns = @JoinColumn(name="customer_id"))
    @JsonIgnore
    private Set<Hotel> hotels;


    public Customer(String customerName, long mobile, String idProof, String gender, String nationality, Address address) {
        this.customerName = customerName;
        this.mobile = mobile;
        this.idProof = idProof;
        this.gender = gender;
        this.nationality = nationality;
        this.address = address;
    }

}
