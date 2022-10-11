package com.hotelapp.service;

import com.hotelapp.exceptions.CustomerNotFoundException;
import com.hotelapp.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotelapp.respository.ICustomerRepository;

import java.util.List;
@Service
public class CustomerServiceImpl implements ICustomerService{

    private ICustomerRepository customerRepository;
    @Autowired
    public void setCustomerRepository(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer addCustomer(Customer customer) {
       return customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(int customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public Customer getCustomerById(int customerId) throws CustomerNotFoundException {
        Customer customer=customerRepository.findById(customerId).get();
        if(customer!=null)
            return customer;
        else
            throw new CustomerNotFoundException("Customer Id not found");
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerByIDProof(String idProof) throws CustomerNotFoundException {
        Customer customer=customerRepository.findByIdProof(idProof);
        if(customer!=null)
            return customer;
        else
            throw new CustomerNotFoundException("Customer IdProof not found");
    }

    @Override
    public List<Customer> getCustomersByGender(String gender) throws CustomerNotFoundException {
        List<Customer> customers=customerRepository.findCustomersByGender(gender);
        if(customers.isEmpty())
            throw new CustomerNotFoundException("Customers of this gender not found");
        else
            return customers;
    }

    @Override
    public List<Customer> getCustomersByNationality(String nationality) throws CustomerNotFoundException {
        List<Customer> customers=customerRepository.findCustomersByNationality(nationality);
        if(customers.isEmpty())
            throw new CustomerNotFoundException("Customers of this nationality not found");
        else
            return customers;
    }

    @Override
    public List<Customer> getCustomersByHotelId(int hotelId) throws CustomerNotFoundException {
        List<Customer> customers=customerRepository.findCustomersByHotelId(hotelId);
        if(customers.isEmpty())
            throw new CustomerNotFoundException("Customers in this hotel id not found");
        else
            return customers;
    }

    @Override
    public Customer getCustomerByBookingId(int bookingId) throws CustomerNotFoundException {
        Customer customer=customerRepository.findCustomerByBookingId(bookingId);
        if(customer!=null)
            return customer;
        else
            throw new CustomerNotFoundException("Customer not found");
    }

    @Override
    public List<Customer> getCustomersByCity(String city) throws CustomerNotFoundException {
        List<Customer> customers=customerRepository.findCustomersByCity(city);
        if(customers.isEmpty())
            throw new CustomerNotFoundException("Customers in this city not found");
        else
            return customers;
    }

    @Override
    public Customer getCustomerByBillingNo(int billingNo) throws CustomerNotFoundException {
        Customer customer=customerRepository.findCustomerByBillingNo(billingNo);
        if(customer!=null)
            return customer;
        else
            throw new CustomerNotFoundException("Customer not found");
    }

    @Override
    public List<Customer> getCustomersByPaymentMode(String paymentMode) {
        List<Customer> customers=customerRepository.findCustomersByPaymentMode(paymentMode);
        if(customers.isEmpty())
            throw new CustomerNotFoundException("Customers paying in this payment mode not found");
        else
            return customers;
    }
}
