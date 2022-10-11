package com.hotelapp.exceptions;

/**
 * @author Madhu Shree Mangi
 * @date : 19-05-2022
 * @project : SpringFinalProject
 */
public class BookingNotFoundException extends RuntimeException {
    public BookingNotFoundException() {
    }

    public BookingNotFoundException(String message) {
        super(message);
    }
}
