package com.hotelapp.controllers;
import com.hotelapp.model.*;
import com.hotelapp.service.IFacilityService;
import com.hotelapp.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("hotel-api")
public class HotelController {

    private IHotelService hotelService;
    @Autowired
    public void setHotelService(IHotelService hotelService) {
        this.hotelService = hotelService;
    }

    private IFacilityService facilityService;

    @Autowired
    public void setFacilityService(IFacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @PostMapping("/admin/hotels")
    ResponseEntity<Void> addHotel(@RequestBody Hotel hotel){
        Set<Booking> bookings = hotel.getBookings();
        Set<Customer> customer = hotel.getCustomers();
        for (Booking booking : bookings) {
            booking.setCustomer((Customer)customer.toArray()[0]);
        }


        List<Rooms> rooms = hotel.getRooms();
        rooms.forEach(room -> room.setHotel(hotel));

        Set<Facilities> facilities=hotel.getFacilities();
        Set<Facilities> facilitiesSet = new HashSet<>();
        for(Facilities facility: facilities){
            Facilities obj = facilityService.getFacilityById(facility.getFacilityId());
            facilitiesSet.add(obj);
        }
        hotel.setFacilities(facilitiesSet);

        hotelService.addHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/admin/hotels")
    ResponseEntity<Void> updateHotel(@RequestBody Hotel hotel){
        hotelService.updateHotel(hotel);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/admin/hotels/id/{hotelId}")
    ResponseEntity<Void> deleteHotel(@PathVariable("hotelId")int hotelId){
        hotelService.deleteHotel(hotelId);
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Deleting hotel by id.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
    }

    @GetMapping("/admin/hotels/id/{hotelId}")
    ResponseEntity<Hotel> showHotelById(@PathVariable("hotelId")int hotelId){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting one hotel by id.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body( hotelService.getHotelById(hotelId));
    }

    @GetMapping("/admin/hotels")
    ResponseEntity<List<Hotel>> showAllHotels(){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting all hotels.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body( hotelService.getAllHotels());
    }

    @GetMapping("/admin/hotels/propertyType/{propertyType}")
    ResponseEntity<List<Hotel>> getByPropertyType(@PathVariable("propertyType") String propertyType){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting all hotels.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body( hotelService.getByPropertyType(propertyType));
    }
    @GetMapping("/admin/hotels/starRatings/{starRatings}")
    ResponseEntity<List<Hotel>> getByStarRatings(@PathVariable("starRatings") String starRatings) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting all hotels.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body( hotelService.getByStarRatings(starRatings));
    }
    @GetMapping("/admin/hotels/hotelName/{hotelName}")
    ResponseEntity<List<Hotel>> getByNameStartingWith(@PathVariable("hotelName") String hotelName) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting all hotels.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body( hotelService.getByHotelNameStartingWith(hotelName));
    }
    @GetMapping("/admin/hotels/facility/{facility}")
    ResponseEntity<List<Hotel>> getByFacilityChoice(@PathVariable("facility") String facility) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting all hotels.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body( hotelService.getByFacilityChoice(facility));
    }
    @GetMapping("/admin/hotels/priceperday/{price}")
    ResponseEntity<List<Hotel>> getByPriceLessThan(@PathVariable("price") double price) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting all hotels.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body( hotelService.getByPriceLessThan(price));
    }
    @GetMapping("/admin/hotels/ratings/{ratings}/starRatings/{starRatings}")
    ResponseEntity<List<Hotel>> getByRatingsAndStarRatings(@PathVariable("ratings") float ratings,@PathVariable("starRatings") String starRatings) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting all hotels.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body( hotelService.getByRatingsAndStarRatings(ratings,starRatings));
    }
    @GetMapping("/admin/hotels/ratings/{ratings}/propertyType/{propertyType}")
    ResponseEntity<List<Hotel>> getHotelByRatingsAndPropertyType(@PathVariable("ratings") float ratings,@PathVariable("propertyType") String propertyType) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting all hotels.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body( hotelService.getHotelByRatingsAndPropertyType(ratings,propertyType));
    }

    @GetMapping("/admin/hotels/city")
    ResponseEntity<List<String>> getDistinctCity() {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting all hotels.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body( hotelService.getDistinctCities());
    }

    @GetMapping("/admin/hotels/city/{city}")
    ResponseEntity<List<Hotel>> getHotelByCity(@PathVariable("city") String city) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting all hotels.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body( hotelService.getHotelByCity(city));
    }

    @GetMapping("/admin/hotels/city/{city}/ratings/{ratings}")
    ResponseEntity<List<Hotel>> getHotelByCityAndRatings(@PathVariable("city") String city,@PathVariable("ratings") float ratings) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting all hotels.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body( hotelService.getHotelByCityAndRatings(city,ratings));
    }
    @GetMapping("/admin/hotels/roomType/{roomType}")
    ResponseEntity<List<Hotel>> getByRoomType(@PathVariable("roomType") String roomType) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting all hotels.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body( hotelService.getByRoomType(roomType));
    }
//    @GetMapping("/admin/hotels/propertyType")
//    ResponseEntity<List<String>> getDistinctPropertyType() {
//        HttpHeaders headers=new HttpHeaders();
//        headers.add("desc","Getting all hotels.");
//        return ResponseEntity.status(HttpStatus.OK).headers(headers).body( hotelService.getDistinctPropertyType());
//    }

    @GetMapping("/admin/hotels/filters/{filter}")
    ResponseEntity<List<String>> getDistinctFilters(@PathVariable("filter")String filter) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting all hotels.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body( hotelService.getDistinctFilters(filter));
    }

    @GetMapping("/admin/hotels/filters/{filter}/filterName/{filterName}")
    ResponseEntity<List<Hotel>> getByFilter(@PathVariable("filter") String filter,@PathVariable("filterName") String filterName) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting all hotels.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body( hotelService.getByFilter(filter, filterName));
    }

    @GetMapping("/admin/hotels/price/{id}")
    ResponseEntity<Double> getHotelPrice(@PathVariable("id")int id) {
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","Getting all hotels.");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body( hotelService.getHotelPrice(id));
    }
}
