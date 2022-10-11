package com.hotelapp;

import com.hotelapp.model.*;
import com.hotelapp.service.ICustomerService;
//import com.hotelapp.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringHotelmanagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args)  {
		SpringApplication.run(SpringHotelmanagementSystemApplication.class, args);
	}

//	private IFacilityService facilityService;
//	@Autowired
//	public void setFacilityService(IFacilityService facilityService) {
//		this.facilityService = facilityService;
//	}
//
//	private ICustomerService customerService;
//	@Autowired
//	public void setCustomerService(ICustomerService customerService) {
//		this.customerService = customerService;
//	}

	@Override
	public void run(String... args) throws Exception {

//		Facilities facility1=new Facilities(Facility.AC.name());
//		Facilities facility2=new Facilities(Facility.BAR.name());
//		Facilities facility3=new Facilities(Facility.FIRSTAID.name());
//		Facilities facility4=new Facilities(Facility.BREAKFAST.name());
//		Facilities facility5=new Facilities(Facility.CCTV.name());
//		Facilities facility6=new Facilities(Facility.DINING.name());
//		Facilities facility7=new Facilities(Facility.PARKING.name());
//		Facilities facility8=new Facilities(Facility.POOL.name());
//
//		facilityService.addFacility(facility1);
//		facilityService.addFacility(facility2);
//		facilityService.addFacility(facility3);
//		facilityService.addFacility(facility4);
//		facilityService.addFacility(facility5);
//		facilityService.addFacility(facility6);
//		facilityService.addFacility(facility7);
//		facilityService.addFacility(facility8);

//		Address address1=new Address("Bangalore","Karnataka","4/23,MG Road",452786);
//		Customer customer1=new Customer("Sharon",9756842157L,"125478965482", Gender.FEMALE.name(),"Indian",address1);
//		customerService.addCustomer(customer1);



	}
}
