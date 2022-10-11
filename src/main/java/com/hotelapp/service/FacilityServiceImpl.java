package com.hotelapp.service;

import com.hotelapp.exceptions.FacilityNotFoundException;
import com.hotelapp.model.Facilities;
import com.hotelapp.respository.IFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Madhu Shree Mangi
 * @date : 16-05-2022
 * @project : SpringFinalProject
 */
@Service
public class FacilityServiceImpl implements IFacilityService{

    private IFacilityRepository facilityRepository;
    @Autowired
    public void setFacilityRepository(IFacilityRepository facilityRepository) {
        this.facilityRepository = facilityRepository;
    }

    @Override
    public void addFacility(Facilities facilities) {
        facilityRepository.save(facilities);
    }

    @Override
    public void updateFacility(Facilities facilities) {
        facilityRepository.save(facilities);
    }

    @Override
    public void deleteFacility(int facilitiesId) {
        facilityRepository.deleteById(facilitiesId);
    }

    @Override
    public Facilities getFacilityById(int facilitiesId) throws FacilityNotFoundException {
        Facilities facility= facilityRepository.findById(facilitiesId).get();
        if(facility!=null)
            return facility;
        else
             throw new FacilityNotFoundException("Facility id not found");
    }

    @Override
    public List<Facilities> getAllFacilities() {
        return facilityRepository.findAll();
    }

    @Override
    public List<Facilities> getByHotelId(int hotelId) throws FacilityNotFoundException {
        List<Facilities> facilities=facilityRepository.findByHotelId(hotelId);
        if(facilities.isEmpty())
            throw new FacilityNotFoundException("No facilities found");
        else
            return facilities;
    }
}
