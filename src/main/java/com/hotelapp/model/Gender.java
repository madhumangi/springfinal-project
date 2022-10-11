package com.hotelapp.model;
/**
 * @author Madhu Shree Mangi
 * @date : 16-05-2022
 * @project : SpringFinalProject
 */
public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    TRANSGENDER("Transgender"),
    PREFERNOTTOSAY("Prefer Not to say");

    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }
}
