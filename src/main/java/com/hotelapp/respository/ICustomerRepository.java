package com.hotelapp.respository;

import com.hotelapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

    Customer findByIdProof(String idProof);
    List<Customer> findCustomersByGender(String gender);
    List<Customer> findCustomersByNationality(String nationality);

    @Query("from Customer c inner join c.hotels h where h.hotelId=?1")
    List<Customer> findCustomersByHotelId(int hotelId);
    @Query("from Customer c inner join c.bookings b where b.bookingId=?1")
    Customer findCustomerByBookingId(int bookingId);
    @Query("from Customer c inner join c.address a where a.city=?1")
    List<Customer> findCustomersByCity(String city);
    @Query(" from Customer c inner join c.bookings b where b.billingNo=?1")
    Customer findCustomerByBillingNo(int billingNo);
    @Query("from Customer c inner join c.bookings b where b.paymentMode=?1")
    List<Customer> findCustomersByPaymentMode(String paymentMode);
}
