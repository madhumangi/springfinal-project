package com.hotelapp.service;

import com.hotelapp.exceptions.HotelNotFoundException;
import com.hotelapp.model.Hotel;

import java.util.List;

public interface IHotelService {

    void addHotel(Hotel hotel);
    void updateHotel(Hotel hotel);
    void deleteHotel(int hotelId);

    Hotel getHotelById(int hotelId) throws HotelNotFoundException;

    List<Hotel> getAllHotels();


    List<Hotel> getByPropertyType(String propertyType) throws HotelNotFoundException;
    List<Hotel> getByStarRatings(String starRatings) throws HotelNotFoundException;
    List<Hotel> getByHotelNameStartingWith(String hotelName) throws HotelNotFoundException;

    List<String> getDistinctCities();
    List<Hotel> getHotelByCity(String city);
    List<Hotel> getByFacilityChoice(String facility) throws HotelNotFoundException;
    List<Hotel> getByPriceLessThan(double price) throws HotelNotFoundException;
    List<Hotel> getByRatingsAndStarRatings(float ratings,String starRatings) throws HotelNotFoundException;
    List<Hotel> getHotelByRatingsAndPropertyType(float ratings, String propertyType) throws HotelNotFoundException;
    List<Hotel> getHotelByCityAndRatings(String city,float ratings) throws HotelNotFoundException;
    List<Hotel> getByRoomType(String roomType) throws HotelNotFoundException;

    List<String> getDistinctFilters(String filter);
    List<Hotel> getByFilter(String filter,String filterName);

    double getHotelPrice(int hotelId);
}
