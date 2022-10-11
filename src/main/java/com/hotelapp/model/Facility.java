package com.hotelapp.model;
/**
 * @author Madhu Shree Mangi
 * @date : 16-05-2022
 * @project : SpringFinalProject
 */
public enum Facility {
    CANCELLATION("Cancellation"),
    PAYLATER("Book Now, Pay Later"),
    BREAKFAST("Breakfast"),
    PAYATHOTEL("Pay At Hotel"),
    AC("Air Conditioning"),
    BANQUETHALL("Banquet hall"),
    BAR("Bar"),
    BONFIRE("Bonfire"),
    CCTV("CCTV Surveillance"),
    CONFERENCEROOM("Conference Room"),
    DINING("Dining"),
    DOCTOR("Doctor On Call"),
    FIRSTAID("First-aid Services"),
    GEYSER("Hot Water"),
    WIFI("Free Internet"),
    ENTERTAINMENT("Indoor Entertainment"),
    LAUNDRY("Laundry Service"),
    LOUNGE("Lounge"),
    OUTDOORACTIVITIES("Outdoor Activities"),
    PARKING("Parking Facility"),
    POOL("Swimming Pool"),
    POWERBACKUP("Power backup"),
    RESTAURANT("Restaurant/Coffee Shop"),
    SMOKINGROOMS("Smoking Rooms"),
    SPA("SPA"),
    TV("TV"),
    WHEELCHAIR("Wheel Chair");

    public String facility;

    Facility(String facility) {
        this.facility = facility;
    }
}
