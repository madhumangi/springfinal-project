package com.hotelapp.service;

import com.hotelapp.exceptions.FacilityNotFoundException;
import com.hotelapp.model.Facilities;

import java.util.List;

public interface IFacilityService {

    void addFacility(Facilities facilities);
    void updateFacility(Facilities facilities);
    void deleteFacility(int facilitiesId);

    Facilities getFacilityById(int facilitiesId) throws FacilityNotFoundException;

    List<Facilities> getAllFacilities();

    List<Facilities> getByHotelId(int hotelId) throws FacilityNotFoundException;
}
