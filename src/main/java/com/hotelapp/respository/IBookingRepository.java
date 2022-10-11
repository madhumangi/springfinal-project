package com.hotelapp.respository;

import com.hotelapp.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IBookingRepository extends JpaRepository<Booking,Integer> {

    List<Booking> findByCheckInDate(LocalDate checkInDate);
    List<Booking> findByCheckOutDate(LocalDate checkOutDate);
    List<Booking> findByTotalCostLessThan(double totalCost);
    List<Booking> findByBillingNo(int billingNo);
    List<Booking> findByPaymentMode(String paymentMode);

    @Query("from Booking b where b.checkInDate=?1 and b.noOfPersons=?2")
    List<Booking> findByCheckInDateAndNoOfPersons(LocalDate checkInDate,int noOfPersons);
    @Query("from Booking b where b.checkOutDate=?1 and b.noOfPersons=?2")
    List<Booking> findByCheckOutDateAndNoOfPersons(LocalDate checkOutDate,int noOfPersons);
    @Query("from Booking b inner join b.hotel h where h.hotelId=?1")
    List<Booking> findByHotelId(int hotelId);
    @Query("from Booking b inner join b.customer c where c.customerId=?1")
    List<Booking> findByCustomerId(int customerId);
    @Query("from Booking b inner join b.room r where r.roomType=?1")
    List<Booking> findByRoomType(String roomType);
    @Query("from Booking b inner join b.hotel h where h.propertyType=?1")
    List<Booking> findByPropertyType(String propertyType);

}
