/******************************************************************************************************************
 * Description    :     MetroServiceApplication
 * 						The SpringBootApplication class for Distance Calculator Service 
 * 						
 * Known Bugs     :     None
 *
 * Modification Log
 * Date                 Author                               Description
 * -------------------------------------------------------------------------
 * Feb, 2018          Infosys  Limited.               Created
 * -------------------------------------------------------------------------
*******************************************************************************************************************/

package com.metro.distance.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metro.distance.calculator.DistanceCalculator;
import com.metro.distance.client.AddressClient;
import com.metro.distance.client.AddressDetails;

@Service
public class DistanceService {

	@Autowired
	private AddressClient addressClient;

	@Autowired
	private DistanceCalculator distanceCalculator;

	/**
	 * The method takes the customer address as the input parameter and provides
	 * selects the warehouse and store for it.
	 * @param Customer Address Name
	 * @Return Time, Store, Warehouse
	 */
	public Map<String, String> getStore(final String name) {
		Map<String, String> result = new HashMap<String, String>();
		AddressDetails drone = new AddressDetails();
		AddressDetails store = new AddressDetails();
		AddressDetails customer = addressClient.getAddress(name);
		List<AddressDetails> drones = addressClient.getAllAddressesType("drones");
		List<AddressDetails> stores = addressClient.getAllAddressesType("store");
		double minDistance = 999999999;
		double currentDistance = 0;
		
		//Checking the distance for each of the customer, store and drone relationship
		//Checking the minimum distance of the combination
		for (int i = 0; i < drones.size(); i++) {

			for (int j = 0; j < stores.size(); j++) {
				currentDistance = distanceCalculator.distance(Double.parseDouble(customer.getLatitude()),
						Double.parseDouble(customer.getLongitude()), Double.parseDouble(stores.get(j).getLatitude()),
						Double.parseDouble(stores.get(j).getLongitude()))
						+ distanceCalculator.distance(Double.parseDouble(drones.get(i).getLatitude()),
								Double.parseDouble(drones.get(i).getLongitude()),
								Double.parseDouble(stores.get(j).getLatitude()),
								Double.parseDouble(stores.get(j).getLongitude()));
				if ((currentDistance <= minDistance)) {
					minDistance = currentDistance;
					drone = drones.get(i);
					store = stores.get(j);
				}
			}

		}

		//Converting the time into miliseconds
		double minTime = minDistance * 60 * 1000;
		//fetching the minutes part
		int timeMinutes = (int) minTime / (60000);
		//fetching the seconds part
		int timeSeconds = (int) (minTime % 60000) / 1000;
		
		result.put("Store", store.getAddressName());
		result.put("Drone", drone.getAddressName());
		result.put("Time", "Minutes:" + timeMinutes + " Seconds:" + timeSeconds);

		return result;
	}

	/**
	 * The method takes the longitude and latitude as the input parameter and provides
	 * selects the warehouse and store for it.
	 * @param Latitude,Longitude
	 * @Return Time, Store, Warehouse
	 */
	public Map<String, String> getStoreLatLong(final String latitude, final String longitude) {
		Map<String, String> result = new HashMap<String, String>();
		AddressDetails drone = null;
		AddressDetails store = null;
		List<AddressDetails> drones = addressClient.getAllAddressesType("drones");
		List<AddressDetails> stores = addressClient.getAllAddressesType("store");
		double minDistance = 999999999;
		double currentDistance = 0;

		//Checking the distance for each of the customer, store and drone relationship
		//Checking the minimum distance of the combination
		for (int i = 0; i < drones.size(); i++) {

			for (int j = 0; j < stores.size(); j++) {
				currentDistance = distanceCalculator.distance(Double.parseDouble(latitude),
						Double.parseDouble(longitude), Double.parseDouble(stores.get(j).getLatitude()),
						Double.parseDouble(stores.get(j).getLongitude()))
						+ distanceCalculator.distance(Double.parseDouble(drones.get(i).getLatitude()),
								Double.parseDouble(drones.get(i).getLongitude()),
								Double.parseDouble(stores.get(j).getLatitude()),
								Double.parseDouble(stores.get(j).getLongitude()));
				if ((currentDistance <= minDistance)) {
					minDistance = currentDistance;
					drone = drones.get(i);
					store = stores.get(j);
				}
			}

		}

		//Converting the time into miliseconds
		double minTime = minDistance * 60 * 1000;
		//fetching the minutes part
		int timeMinutes = (int) minTime / (60000);
		//fetching the seconds part
		int timeSeconds = (int) (minTime % 60000) / 1000;
		result.put("Store", store.getAddressName());
		result.put("Drone", drone.getAddressName());
		result.put("Time", "Minutes:" + timeMinutes + " Seconds:" + timeSeconds);

		return result;

	}

}
