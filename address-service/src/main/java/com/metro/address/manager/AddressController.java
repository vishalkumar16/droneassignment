/******************************************************************************************************************
 * Description    :     AddressController
 * 						The rest controller for providing all the address specific details
 * 						
 * Known Bugs     :     None
 *
 * Modification Log
 * Date                 Author                               Description
 * -------------------------------------------------------------------------
 * Feb, 2018          Infosys  Limited.               Created
 * -------------------------------------------------------------------------
*******************************************************************************************************************/

package com.metro.address.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metro/addresses")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	/**
	 * Get the address details for the customer such as latitude
	 * and longitude
	 * @param name(Customer Address Name)
	 * @return AddressDetails
	 */
	@GetMapping("/getAddressDetails/{name}")
	public AddressDetails getAddress(@PathVariable String name){
		return addressService.getAddress(name);
	}
	
	/**
	 * Get the list address details for the customer such as latitude
	 * and longitude for all for a specific user type such as customer,drone or store
	 * @para, type (User Type = {store, customer, drone})
	 * @return List<Address Details>
	 */
	@GetMapping("/getAddresses/{type}")
	public List<AddressDetails> getAllAddressesType(@PathVariable String type){
		return addressService.getAllAddressesType(type);
	}

	/**
	 * Get the information on all the customers
	 * @return List<Address Details>
	 */
	@GetMapping("/getAddresses")
	public List<AddressDetails> getAllAddresse(){
		return addressService.getAllAddress();
	}
	

}
