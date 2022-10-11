package com.hotelapp.service;

import com.hotelapp.exceptions.BookingNotFoundException;
import com.hotelapp.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotelapp.respository.IBookingRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingServiceImpl implements IBookingService{

    private IBookingRepository bookingRepository;
    @Autowired
    public void setBookingRepository(IBookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }


    @Override
    public void addBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public void updateBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(int bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    @Override
    public Booking getBookingById(int bookingId) throws BookingNotFoundException {
           Booking booking= bookingRepository.findById(bookingId).get();
           if(booking!=null)
               return booking;
           else
               throw new BookingNotFoundException("Booking id not found");
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> getByCheckInDate(LocalDate checkInDate) throws BookingNotFoundException {
        List<Booking> bookings=bookingRepository.findByCheckInDate(checkInDate);
        if(bookings.isEmpty())
            throw new BookingNotFoundException("Bookings with this Check In Date not found");
        else
            return bookings;
    }

    @Override
    public List<Booking> getByCheckOutDate(LocalDate checkOutDate) throws BookingNotFoundException {
        List<Booking> bookings=bookingRepository.findByCheckOutDate(checkOutDate);
        if(bookings.isEmpty())
            throw new BookingNotFoundException("Bookings with this Check Out Date not found");
        else
            return bookings;
    }

    @Override
    public List<Booking> getByTotalCostLessThan(double totalCost) throws BookingNotFoundException {
        List<Booking> bookings=bookingRepository.findByTotalCostLessThan(totalCost);
        if(bookings.isEmpty())
            throw new BookingNotFoundException("Bookings less than this cost not found");
        else
            return bookings;
    }

    @Override
    public List<Booking> getByBillingNo(int billingNo) throws BookingNotFoundException {
        List<Booking> bookings=bookingRepository.findByBillingNo(billingNo);
        if(bookings.isEmpty())
            throw new BookingNotFoundException("Bookings with this billing no. not found");
        else
            return bookings;
    }

    @Override
    public List<Booking> getByPaymentMode(String paymentMode) throws BookingNotFoundException {
        List<Booking> bookings=bookingRepository.findByPaymentMode(paymentMode);
        if(bookings.isEmpty())
            throw new BookingNotFoundException("Bookings with this payment mode not found");
        else
            return bookings;
    }

    @Override
    public List<Booking> getByCheckInDateAndNoOfPersons(LocalDate checkInDate, int noOfPersons) throws BookingNotFoundException {
        List<Booking> bookings=bookingRepository.findByCheckInDateAndNoOfPersons(checkInDate, noOfPersons);
        if(bookings.isEmpty())
            throw new BookingNotFoundException("Bookings not found");
        else
            return bookings;
    }

    @Override
    public List<Booking> getByCheckOutDateAndNoOfPersons(LocalDate checkOutDate, int noOfPersons) throws BookingNotFoundException {
        List<Booking> bookings=bookingRepository.findByCheckOutDateAndNoOfPersons(checkOutDate, noOfPersons);
        if(bookings.isEmpty())
            throw new BookingNotFoundException("Bookings not found");
        else
            return bookings;
    }

    @Override
    public List<Booking> getByHotelId(int hotelId) throws BookingNotFoundException {
        List<Booking> bookings=bookingRepository.findByHotelId(hotelId);
        if(bookings.isEmpty())
            throw new BookingNotFoundException("Bookings with this hotel id not found");
        else
            return bookings;
    }

    @Override
    public List<Booking> getByCustomerId(int customerId) throws BookingNotFoundException {
        List<Booking> bookings=bookingRepository.findByCustomerId(customerId);
        if(bookings.isEmpty())
            throw new BookingNotFoundException("Bookings with this customer id not found");
        else
            return bookings;
    }

    @Override
    public List<Booking> getByRoomType(String roomType) throws BookingNotFoundException {
        List<Booking> bookings=bookingRepository.findByRoomType(roomType);
        if(bookings.isEmpty())
            throw new BookingNotFoundException("Bookings of this room type not found");
        else
            return bookings;
    }

    @Override
    public List<Booking> getByPropertyType(String propertyType) throws BookingNotFoundException {
        List<Booking> bookings=bookingRepository.findByPropertyType(propertyType);
        if(bookings.isEmpty())
            throw new BookingNotFoundException("Bookings in this property type not found");
        else
            return bookings;
    }

}
