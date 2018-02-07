/******************************************************************************************************************
 * Description    :     AddressService
 * 						Service created to handle all the methods required to provide address details to metro
 * 						
 * Known Bugs     :     None
 *
 * Modification Log
 * Date                 Author                               Description
 * -------------------------------------------------------------------------
 * Jul, 2013          Infosys  Limited.               Created
 * -------------------------------------------------------------------------
*******************************************************************************************************************/

package com.metro.address.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class AddressService {


	//List created for 
	private List<AddressDetails> addresses = new ArrayList<>(
			Arrays.asList(new AddressDetails("Metrostrasse 12, 40235 Düsseldorf", "6.825636", "51.234672", "drones"),
					new AddressDetails("Am Albertussee 1, 40549 Düsseldorf", "6.724243", "51.236796", "drones"),
					new AddressDetails("Kronprinzenstraße 88, 40217 Düsseldorf", "6.770084", "51.211716", "customer"),
					new AddressDetails("Kaiserstraße 2, 40479 Düsseldorf", "6.778400", "51.235160", "customer"),
					new AddressDetails("Wildenbruchstraße 2, 40545 Düsseldorf", "6.759937", "51.227598", "customer"),
					new AddressDetails("Schlesische Straße 5, 40231 Düsseldorf", "6.831059", "51.208053", "customer"),
					new AddressDetails("Schiessstraße 31, 40549 Düsseldorf", "6.719612", "51.237636", "store"),
					new AddressDetails("Friedrichstraße 152, 40217 Düsseldorf", "6.778820", "51.208938", "store"),
					new AddressDetails("Breslauer Str. 2, 41460 Neuss", "6.718629", "51.201994", "store"),
					new AddressDetails("Bataverstraße 93, 41462 Neuss", "6.685699", "51.231234", "store"),
					new AddressDetails("Am Sandbach 30, 40878 Ratingen", "6.831492", "51.296507", "store")));


	/**
	 * Get the address details for the customer such as latitude
	 * and longitude
	 * @param name(Customer Address Name)
	 * @return AddressDetails
	 */
	public AddressDetails getAddress(String name) {
		
		//Java 8 feature allows to convert a list to stream allowing to filter it on a particular customer name
		//Features used : Lambda Expressions, Stream, Filter
		return addresses.stream().filter(t -> t.getAddressName().equals(name)).findFirst().get();
	}

	/**
	 * Get the list address details for the customer such as latitude
	 * and longitude for all for a specific user type such as customer,drone or store
	 * @para, type (User Type = {store, customer, drone})
	 * @return List<Address Details>
	 */
	public List<AddressDetails> getAllAddressesType(String addressType) {
		
		//Java 8 feature allows to convert a list to stream allowing to filter it on a particular customer name
		//Features used : Lambda Expressions, Stream, Filter
		return addresses.stream().filter(t -> t.getType().equals(addressType)).collect(Collectors.toList());

	}

	/**
	 * Get the information on all the customers
	 * @return List<Address Details>
	 */
	public List<AddressDetails> getAllAddress() {
		return addresses;
	}

	

}
