package com.hotelapp.model;
/**
 * @author Madhu Shree Mangi
 * @date : 16-05-2022
 * @project : SpringFinalProject
 */
public enum StarRatings {
    FIVE("5 Star"),
    FOUR("4 Star"),
    THREE("3 Star"),
    TWO("2 Star"),
    ONE("1 Star");

    private String ratings;

    StarRatings(String ratings) {
        this.ratings = ratings;
    }
}
