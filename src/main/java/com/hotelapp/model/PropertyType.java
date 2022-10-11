package com.hotelapp.model;
/**
 * @author Madhu Shree Mangi
 * @date : 16-05-2022
 * @project : SpringFinalProject
 */
public enum PropertyType {
    HOTEL("Hotel"),
    APPARTMENT("Appartment"),
    HOMESTAY("Home Stay"),
    GUESTHOUSE("Guest House"),
    APARTHOTEL("Aparthotel"),
    VILLA("Villa"),
    HOSTEL("Hostel"),
    LODGE("Lodge"),
    RESORT("Resort"),
    HOLIDAYHOMES("Holiday Homes"),
    FARMHOUSE("Farm House"),
    COTTAGE("Cottage"),
    MOTEL("Motel");

    private String type;

    PropertyType(String type) {
        this.type = type;
    }
}
