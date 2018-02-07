/******************************************************************************************************************
 * Description    :     DistanceController
 * 						Controller created for providing the store and warehouse based
 * 						on the distance 
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

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metro/distance")
public class DistanceController {
	
	@Autowired
	private DistanceService distanceService;


	/**This method would be used when the customer passes the customer address
	 * @param Customer Address
	 * @return Time,Store,Warehouse
	 */

	@GetMapping("/getStore/{name}")
	public Map<String,String> getStore(@PathVariable String name){
		return distanceService.getStore(name);
	}  
	
	/**This method would be used when the customer data is not available with us
	 * but the latitude and longitude information is available
	 * @param Latitude(String) and Longitude(String)
	 * @return Time,Store,Warehouse
	 */
	@GetMapping("/getStoreWithLatitudeLongitude")
	public Map<String,String> getStoreLatLong(
			@RequestParam("latitude") String latitude,
			@RequestParam("longitude") String longitude){	
		return distanceService.getStoreLatLong(latitude, longitude);
	}  
	
	
	
	
}
