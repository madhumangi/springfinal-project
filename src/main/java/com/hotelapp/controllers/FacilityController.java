package com.hotelapp.controllers;

import com.hotelapp.model.Facilities;
import com.hotelapp.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Madhu Shree Mangi
 * @date : 16-05-2022
 * @project : SpringFinalProject
 */
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("facility-api")
public class FacilityController {

    private IFacilityService facilityService;
    @Autowired
    public void setFacilityService(IFacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @PostMapping("/admin/facilities")
    ResponseEntity<Void> addFacility(@RequestBody Facilities facilities) {
        facilityService.addFacility(facilities);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/admin/facilities")
    ResponseEntity<Void> updateFacility(@RequestBody Facilities facilities){
        facilityService.updateFacility(facilities);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/admin/facilities/id/{facilityId}")
    ResponseEntity<Void> deleteFacility(@PathVariable("facilityId")int facilityId){
        facilityService.deleteFacility(facilityId);
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Deleting facility by id.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
    }

    @GetMapping("/admin/facilities/id/{facilityId}")
    ResponseEntity<Facilities> showFacilityById(@PathVariable("facilityId")int facilityId){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting one facility by id.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(facilityService.getFacilityById(facilityId));
    }

    @GetMapping("/admin/facilities")
    ResponseEntity<List<Facilities>> showAllFacilities(){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting all facilities.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body( facilityService.getAllFacilities());
    }
    @GetMapping("/admin/facilities/hotel-id/{id}")
    ResponseEntity<List<Facilities>> showFacilityByHotelId(@PathVariable("id")int hotelId){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting one facility by id.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(facilityService.getByHotelId(hotelId));
    }
}
