package com.hotelapp.service;

import com.hotelapp.exceptions.BookingNotFoundException;
import com.hotelapp.model.Booking;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface IBookingService{

    void addBooking(Booking booking);
    void updateBooking(Booking booking);
    void deleteBooking(int bookingId);

    Booking getBookingById(int bookingId) throws BookingNotFoundException;

    List<Booking> getAllBookings();

    List<Booking> getByCheckInDate(LocalDate checkInDate) throws BookingNotFoundException;
    List<Booking> getByCheckOutDate(LocalDate checkOutDate) throws BookingNotFoundException;
    List<Booking> getByTotalCostLessThan(double totalCost) throws BookingNotFoundException;
    List<Booking> getByBillingNo(int billingNo) throws BookingNotFoundException;
    List<Booking> getByPaymentMode(String paymentMode) throws BookingNotFoundException;
    List<Booking> getByCheckInDateAndNoOfPersons(LocalDate checkInDate,int noOfPersons) throws BookingNotFoundException;
    List<Booking> getByCheckOutDateAndNoOfPersons(LocalDate checkOutDate,int noOfPersons) throws BookingNotFoundException;
    List<Booking> getByHotelId(int hotelId) throws BookingNotFoundException;
    List<Booking> getByCustomerId(int customerId) throws BookingNotFoundException;
    List<Booking> getByRoomType(String roomType) throws BookingNotFoundException;
    List<Booking> getByPropertyType(String propertyType) throws BookingNotFoundException;
}
