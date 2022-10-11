package com.hotelapp.service;

import com.hotelapp.exceptions.HotelNotFoundException;
import com.hotelapp.model.Booking;
import com.hotelapp.model.Customer;
import com.hotelapp.model.Hotel;
import com.hotelapp.respository.IBookingRepository;
import com.hotelapp.respository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotelapp.respository.IHotelRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Float.parseFloat;

@Service
public class HotelServiceImpl implements IHotelService{

    private IHotelRepository hotelRepository;
    private IBookingRepository bookingRepository;
    private ICustomerRepository customerRepository;
    @Autowired
    public void setHotelRepository(IHotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void addHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public void updateHotel(Hotel hotel) {
            hotelRepository.save(hotel);
    }

    @Override
    public void deleteHotel(int hotelId) {
        hotelRepository.deleteById(hotelId);
    }

    @Override
    public Hotel getHotelById(int hotelId) throws HotelNotFoundException{
        Hotel hotel= hotelRepository.findById(hotelId).get();
        if(hotel!=null)
            return hotel;
        else
            throw new HotelNotFoundException("Hotel Id not found");
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public List<Hotel> getByPropertyType(String propertyType) {
        return hotelRepository.findByPropertyType(propertyType);
    }

    @Override
    public List<Hotel> getByStarRatings(String starRatings) throws HotelNotFoundException {
        List<Hotel> hotels=hotelRepository.findByStarRatings(starRatings);
        if(hotels.isEmpty())
            throw new HotelNotFoundException("Hotels of this star rating not found");
        else
            return hotels;
    }

    @Override
    public List<Hotel> getByHotelNameStartingWith(String hotelName) throws HotelNotFoundException {
        List<Hotel> hotels=hotelRepository.findByHotelNameStartingWith(hotelName);
        if(hotels.isEmpty())
            throw new HotelNotFoundException("Hotels not found");
        else
            return hotels;
    }

    @Override
    public List<String> getDistinctCities() {
        return hotelRepository.findDistinctCities();
    }

    @Override
    public List<Hotel> getHotelByCity(String city) {
        List<Hotel> hotels=hotelRepository.findHotelByCity(city);
        return hotels;
    }

    @Override
    public List<Hotel> getByFacilityChoice(String facility) throws HotelNotFoundException {
        List<Hotel> hotels=hotelRepository.findByFacilityChoice(facility);
        if(hotels.isEmpty())
            throw new HotelNotFoundException("Hotels with this facility not found");
        else
            return hotels;
    }

    @Override
    public List<Hotel> getByPriceLessThan(double price) throws HotelNotFoundException {
        List<Hotel> hotels=hotelRepository.findByPriceLessThan(price);
        if(hotels.isEmpty())
            throw new HotelNotFoundException("Hotels price in this range not found");
        else
            return hotels;
    }

    @Override
    public List<Hotel> getByRatingsAndStarRatings(float ratings, String starRatings) throws HotelNotFoundException {
        List<Hotel> hotels=hotelRepository.findByRatingsAndStarRatings(ratings, starRatings);
        if(hotels.isEmpty())
            throw new HotelNotFoundException("Hotels not found");
        else
            return hotels;
    }

    @Override
    public List<Hotel> getHotelByRatingsAndPropertyType(float ratings, String propertyType) throws HotelNotFoundException {
        List<Hotel> hotels=hotelRepository.findHotelByRatingsAndPropertyType(ratings, propertyType);
        if(hotels.isEmpty())
            throw new HotelNotFoundException("Hotels not found");
        else
            return hotels;
    }

    @Override
    public List<Hotel> getHotelByCityAndRatings(String city, float ratings) throws HotelNotFoundException {
        List<Hotel> hotels=hotelRepository.findHotelByCityAndRatings(city, ratings);
        if(hotels.isEmpty())
            throw new HotelNotFoundException("Hotels not found");
        else
            return hotels;
    }

    @Override
    public List<Hotel> getByRoomType(String roomType) throws HotelNotFoundException {
        List<Hotel> hotels=hotelRepository.findByRoomType(roomType);
        if(hotels.isEmpty())
            throw new HotelNotFoundException("Hotels not found");
        else
            return hotels;
    }

    @Override
    public List<String> getDistinctFilters(String filter) {
        List<String> ratings=new ArrayList<>(Arrays.asList("6.0","7.0","8.0","9.0"));
        if(filter.equalsIgnoreCase("Property Type"))
            return hotelRepository.findDistinctPropertyType();
        else if(filter.equals("Star Ratings"))
            return hotelRepository.findDistinctStarRatings();
        else if(filter.equals("Facilities"))
            return hotelRepository.findDistinctFacilities();
        else if(filter.equals("Ratings"))
            return ratings;
        else
            return null;
    }

    @Override
    public List<Hotel> getByFilter(String filter, String filterName) {
        if(filter.equals("Property Type"))
            return hotelRepository.findByPropertyType(filterName);
        else if(filter.equals("Star Ratings"))
            return hotelRepository.findByStarRatings(filterName);
        else if(filter.equals("Facilities"))
            return hotelRepository.findByFacilityChoice(filterName);
        else if(filter.equals("Ratings"))
            return hotelRepository.findByRatings(parseFloat(filterName));
        else
            return null;
    }

    @Override
    public double getHotelPrice(int hotelId) {
        return hotelRepository.showHotelPrice(hotelId);
    }
}
