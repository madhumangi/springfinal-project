package com.hotelapp.controllers;

import com.hotelapp.exceptions.CustomerNotFoundException;
import com.hotelapp.model.Address;
import com.hotelapp.model.Booking;
import com.hotelapp.model.Hotel;
import com.hotelapp.service.IBookingService;
import com.hotelapp.service.ICustomerService;
import com.hotelapp.model.Customer;
import com.hotelapp.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("customer-api")
public class CustomerController {

    private ICustomerService customerService;
    @Autowired
    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }

    private IBookingService bookingService;
    @Autowired
    public void setBookingService(IBookingService bookingService) {
        this.bookingService = bookingService;
    }

    private IHotelService hotelService;
    @Autowired
    public void setHotelService(IHotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/customers")
    ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Set<Booking> bookings=customer.getBookings();
        bookings.forEach(booking ->  booking.setCustomer(customer));

        Set<Hotel> hotels=customer.getHotels();
        Set<Hotel> hotelSet=new HashSet<>();
        for (Hotel hotel:hotels) {
            hotelSet.add(hotelService.getHotelById(hotel.getHotelId()));
        }
        customer.setHotels(hotelSet);
        customerService.addCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/customers")
    ResponseEntity<Void> updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/customers/id/{customerId}")
    ResponseEntity<Void> deleteCustomer(@PathVariable("customerId")int customerId){
        customerService.deleteCustomer(customerId);
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Deleting customer by id.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
    }

    @GetMapping("/admin/customers/id/{customerId}")
    ResponseEntity<Customer> showCustomerById(@PathVariable("customerId")int customerId){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting one customer by id.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(customerService.getCustomerById(customerId));
    }

    @GetMapping("/admin/customers")
    ResponseEntity<List<Customer>> showAllCustomers(){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting all customers.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(customerService.getAllCustomers());
    }
    @GetMapping("/admin/customers/iDProof/{iDProof}")
    ResponseEntity<Customer> getCustomerByIDProof(@PathVariable("iDProof") String iDProof) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting customers by id proof.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(customerService.getCustomerByIDProof(iDProof));
    }
    @GetMapping("/admin/customers/gender/{gender}")
    ResponseEntity<List<Customer>> getCustomersByGender(@PathVariable("gender") String gender) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting customers by gender.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(customerService.getCustomersByGender(gender));
    }
    @GetMapping("/admin/customers/nationality/{nationality}")
    ResponseEntity<List<Customer>> getCustomersByNationality(@PathVariable("nationality") String nationality) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting customers by nationality.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(customerService.getCustomersByNationality(nationality));
    }

    @GetMapping("/admin/customers/hotelId/{hotelId}")
    ResponseEntity<List<Customer>> getCustomersByHotelId(@PathVariable("hotelId") int hotelId) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting customers by hotelId.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(customerService.getCustomersByHotelId(hotelId));
    }
    @GetMapping("/admin/customers/bookingId/{bookingId}")
    ResponseEntity<Customer> getCustomerByBookingId(@PathVariable("bookingId") int bookingId) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting all customers.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(customerService.getCustomerByBookingId(bookingId));
    }
    @GetMapping("/admin/customers/city/{city}")
    ResponseEntity<List<Customer>> getCustomersByCity(@PathVariable("city") String city) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting all customers.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(customerService.getCustomersByCity(city));
    }
    @GetMapping("/admin/customers/billingNo/{billingNo}")
    ResponseEntity<Customer> getCustomerByBillingNo(@PathVariable("billingNo") int billingNo) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting all customers.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(customerService.getCustomerByBillingNo(billingNo));
    }
    @GetMapping("/admin/customers/paymentMode/{paymentMode}")
    ResponseEntity<List<Customer>> getCustomersByPaymentMode(@PathVariable("paymentMode") String paymentMode){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting all customers.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(customerService.getCustomersByPaymentMode(paymentMode));
    }
}
