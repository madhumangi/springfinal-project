package com.hotelapp.exceptions;

/**
 * @author Madhu Shree Mangi
 * @date : 18-05-2022
 * @project : SpringFinalProject
 */
public class FacilityNotFoundException extends RuntimeException {
    public FacilityNotFoundException() {
    }

    public FacilityNotFoundException(String message) {
        super(message);
    }
}
