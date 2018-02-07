package com.metro.test.address;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.context.junit4.SpringRunner;

import com.metro.address.manager.AddressDetails;
import com.metro.address.manager.AddressService;

@RunWith(SpringRunner.class)
@TestComponent
public class AddressRespositoryTest {

	@Autowired
	private AddressService addressService;

	/**
	 * Checking if the method returns the correct value of longitude
	 * for the customer
	 */
	@Test
	public void testCustomerDetailsLongitude() {
		AddressDetails addressDetails = addressService.getAddress("Am Albertussee 1, 40549 Düsseldorf");
		assertEquals("6.724243",addressDetails.getLongitude());
	}
	
	
	/**
	 * Checking if the method returns the correct value of latitude
	 * for the customer
	 */
	@Test
	public void testCustomerDetailsLatitude() {
		AddressDetails addressDetails = addressService.getAddress("Am Albertussee 1, 40549 Düsseldorf");
		assertEquals("51.236796",addressDetails.getLatitude());
	}
	
}
