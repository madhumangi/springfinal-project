package com.hotelapp.exceptions;

/**
 * @author Madhu Shree Mangi
 * @date : 18-05-2022
 * @project : SpringFinalProject
 */
public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException() {
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
