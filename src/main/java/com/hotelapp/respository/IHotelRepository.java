package com.hotelapp.respository;

import com.hotelapp.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHotelRepository extends JpaRepository<Hotel,Integer> {

    //derived queries

    /**
     * This method will allow us to filter hotels by property type
     * @param propertyType
     * @return List of hotels
     */
    List<Hotel> findByPropertyType(String propertyType);

    /**
     * This method will allow us to filter hotels by star ratings(5 star/4 star so on)
     * @param starRatings
     * @return List of hotels
     */
    List<Hotel> findByStarRatings(String starRatings);

    /**
     * This method will allow us to get hotels by the starting letter/word of its name
     * @param hotelName
     * @return
     */
    List<Hotel> findByHotelNameStartingWith(String hotelName);

//    List<Hotel> findByRatings(double ratings);

    //Customized queries

    /**
     * This method will allow us to filter hotels by any of its facilities
     * @param facility
     * @return List of hotels
     */
    @Query("from Hotel h inner join h.facilities f where f.facilityName=?1")
    List<Hotel> findByFacilityChoice(String facility);

    @Query("from Hotel h where h.ratings>=?1 and h.starRatings=?2")
    List<Hotel> findByRatingsAndStarRatings(float ratings,String starRatings);

    @Query("from Hotel h where h.ratings>=?1 and h.propertyType=?2")
    List<Hotel> findHotelByRatingsAndPropertyType(float ratings, String propertyType);

    @Query("select distinct a.city from Hotel h inner join h.address a")
    List<String> findDistinctCities();

    @Query("from Hotel h inner join h.address a where a.city=?1")
    List<Hotel> findHotelByCity(String city);

    @Query("from Hotel h inner join h.address a where a.city=?1 and h.ratings>=?2")
    List<Hotel> findHotelByCityAndRatings(String city,float ratings);

    @Query("from Hotel h inner join h.rooms r where r.roomType=?1")
    List<Hotel> findByRoomType(String roomType);

    @Query("from Hotel h inner join h.rooms r where r.pricePerDay=?1")
    List<Hotel> findByPriceLessThan(double price);

    @Query("select distinct starRatings from Hotel")
    List<String> findDistinctStarRatings();

    @Query("select distinct f.facilityName from Hotel h inner join h.facilities f")
    List<String> findDistinctFacilities();

    @Query("select distinct propertyType from Hotel")
    List<String> findDistinctPropertyType();

    @Query("from Hotel h where h.ratings>?1")
    List<Hotel> findByRatings(float ratings);

    @Query("select r.pricePerDay from Hotel h inner join h.rooms r where r.roomType='Double' and h.hotelId=?1")
    double showHotelPrice(int hotelId);
}
