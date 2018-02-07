/******************************************************************************************************************
 * Description    :     AddressClient
 * 						This client acts as interface by consuming the REST APIs exposed by Address Service 
 * 						
 * Known Bugs     :     None
 *
 * Modification Log
 * Date                 Author                               Description
 * -------------------------------------------------------------------------
 * Feb, 2018          Infosys  Limited.               Created
 * -------------------------------------------------------------------------
*******************************************************************************************************************/

package com.metro.distance.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

@Component
public class AddressClient {
	
	private final String url1;
	private final String url2;

	@Autowired
	public AddressClient(@Value("${url.get.address}") final String url1,@Value("${url.get.address.type}") final String url2) {
		this.url1 = url1;
		this.url2 = url2;
	}

	@Autowired
	private RestOperations restOperations;

	/**
	 * Get the address details for the customer such as latitude
	 * and longitude
	 * @param name(Customer Address Name)
	 * @return AddressDetails
	 */
	public AddressDetails getAddress(final String name) {

		return restOperations.getForObject(url1, AddressDetails.class, name);
	}


	/**
	 * Get the list address details for the customer such as latitude
	 * and longitude for all for a specific user type such as customer,drone or store
	 * @para, type (User Type = {store, customer, drone})
	 * @return Address Detailson
	 */
	public List<AddressDetails> getAllAddressesType(final String type) {

		return Arrays.asList(restOperations.getForEntity(url2, AddressDetails[].class, type).getBody());
	}
	
	

	
	

}
