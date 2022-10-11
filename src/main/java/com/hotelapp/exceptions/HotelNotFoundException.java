package com.hotelapp.exceptions;

/**
 * @author Madhu Shree Mangi
 * @date : 18-05-2022
 * @project : SpringFinalProject
 */
public class HotelNotFoundException extends RuntimeException {

    public HotelNotFoundException() {
    }

    public HotelNotFoundException(String message) {
        super(message);
    }
}
