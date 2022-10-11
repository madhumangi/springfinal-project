package com.hotelapp.service;

import com.hotelapp.exceptions.CustomerNotFoundException;
import com.hotelapp.model.Customer;

import java.util.List;

public interface ICustomerService {

    Customer addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int customerId);

    Customer getCustomerById(int customerId) throws CustomerNotFoundException;

    List<Customer> getAllCustomers();

    Customer getCustomerByIDProof(String idProof) throws CustomerNotFoundException;
    List<Customer> getCustomersByGender(String gender) throws CustomerNotFoundException;
    List<Customer> getCustomersByNationality(String nationality) throws CustomerNotFoundException;
    List<Customer> getCustomersByHotelId(int hotelId) throws CustomerNotFoundException;
    Customer getCustomerByBookingId(int bookingId) throws CustomerNotFoundException;
    List<Customer> getCustomersByCity(String city) throws CustomerNotFoundException;
    Customer getCustomerByBillingNo(int billingNo) throws CustomerNotFoundException;
    List<Customer> getCustomersByPaymentMode(String paymentMode);
}
