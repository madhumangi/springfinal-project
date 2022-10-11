package com.hotelapp.controllers;

import com.hotelapp.exceptions.BookingNotFoundException;
import com.hotelapp.model.*;
import com.hotelapp.respository.IHotelRepository;
import com.hotelapp.service.IBookingService;
import com.hotelapp.service.ICustomerService;
import com.hotelapp.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("booking-api")
public class BookingController {
    
    private IBookingService bookingService;
    @Autowired
    public void setBookingService(IBookingService bookingService) {
        this.bookingService = bookingService;
    }

    private ICustomerService customerService;
    @Autowired
    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }

    private IHotelService hotelService;
    @Autowired
    public void setHotelService(IHotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/bookings")
    ResponseEntity<Void> addNewBooking(@RequestBody Booking booking){
        Customer customer=booking.getCustomer();
        booking.setCustomer(customerService.getCustomerById(customer.getCustomerId()));

        Hotel hotel=booking.getHotel();
        booking.setHotel(hotelService.getHotelById(hotel.getHotelId()));

        Rooms room=booking.getRoom();
        room.setBooking(booking);

        bookingService.addBooking(booking);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/bookings")
    ResponseEntity<Void> updateExistingBooking(@RequestBody Booking booking){
        bookingService.updateBooking(booking);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/bookings/id/{bookingId}")
    ResponseEntity<Void> deleteExistingBooking(@PathVariable("bookingId")int bookingId){
        bookingService.deleteBooking(bookingId);
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Deleting booking by id.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
    }

    @GetMapping("/bookings/id/{bookingId}")
    ResponseEntity<Booking> showBookingById(@PathVariable("bookingId")int bookingId){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting one booking by id.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body( bookingService.getBookingById(bookingId));
    }

    @GetMapping("/bookings")
    ResponseEntity<List<Booking>> showAllBookings(){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting all bookings.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(bookingService.getAllBookings());
    }
    @GetMapping("/bookings/checkInDate/{checkInDate}")
    ResponseEntity<List<Booking>>  showByCheckInDate(@PathVariable("checkInDate") LocalDate checkInDate) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting bookings by checkInDate.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(bookingService.getByCheckInDate(checkInDate));
    }
    @GetMapping("/bookings/checkOutDate/{checkOutDate}")
    ResponseEntity<List<Booking>>  showByCheckOutDate(@PathVariable("checkOutDate") LocalDate checkOutDate) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting bookings bu checkOutDate.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(bookingService.getByCheckOutDate(checkOutDate));
    }
    @GetMapping("/bookings/totalCost/{totalCost}")
    ResponseEntity<List<Booking>>  showByTotalCostLessThan(@PathVariable("totalCost") double totalCost) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting bookings by total cost.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(bookingService.getByTotalCostLessThan(totalCost));
    }
    @GetMapping("/bookings/billingNo/{billingNo}")
    ResponseEntity<List<Booking>> showByBillingNo(@PathVariable("billingNo") int billingNo) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting bookings by billing no.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(bookingService.getByBillingNo(billingNo));
    }
    @GetMapping("/bookings/paymentMode/{paymentMode}")
    ResponseEntity<List<Booking>>  showByPaymentMode(@PathVariable("paymentMode") String paymentMode) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting bookings by payment mode.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(bookingService.getByPaymentMode(paymentMode));
    }
    @GetMapping("/bookings/checkInDate/{checkInDate}/noOfPersons/{noOfPersons}")
    ResponseEntity<List<Booking>>  showByCheckInDateAndNoOfPersons(@PathVariable("checkInDate") LocalDate checkInDate,@PathVariable("noOfPersons") int noOfPersons) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting bookings by check in date and no of persons.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(bookingService.getByCheckInDateAndNoOfPersons(checkInDate,noOfPersons));
    }
    @GetMapping("/bookings/checkOutDate/{checkOutDate}/noOfPersons/{noOfPersons}")
    ResponseEntity<List<Booking>>  showByCheckOutDateAndNoOfPersons(@PathVariable("checkOutDate") LocalDate checkOutDate,@PathVariable("noOfPersons")int noOfPersons) {

        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting bookings by check out date and no of persons.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(bookingService.getByCheckOutDateAndNoOfPersons(checkOutDate,noOfPersons));
    }
    @GetMapping("/bookings/hotelId/{hotelId}")
    ResponseEntity<List<Booking>>  showByHotelId(@PathVariable("hotelId") int hotelId) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting bookings by hotelId.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(bookingService.getByHotelId(hotelId));
    }
    @GetMapping("/bookings/customerId/{customerId}")
    ResponseEntity<List<Booking>>  showByCustomerId(@PathVariable("customerId") int customerId) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting bookings by customer id.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(bookingService.getByCustomerId(customerId));
    }
    @GetMapping("/bookings/roomType/{roomType}")
    ResponseEntity<List<Booking>>  showByRoomType(@PathVariable("roomType") String roomType) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting bookings by room type.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(bookingService.getByRoomType(roomType));
    }
    @GetMapping("/bookings/propertyType/{propertyType}")
    ResponseEntity<List<Booking>>  showByPropertyType(@PathVariable("propertyType") String propertyType) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting bookings by property type.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(bookingService.getByPropertyType(propertyType));
    }
}
