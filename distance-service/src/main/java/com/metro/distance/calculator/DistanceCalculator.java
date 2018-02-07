/******************************************************************************************************************
 * Description    :     DistanceCalculator
 * 						The class created for handling methods related to distance calculation 
 * 						
 * Known Bugs     :     None
 *
 * Modification Log
 * Date                 Author                               Description
 * -------------------------------------------------------------------------
 * Feb, 2018          Infosys  Limited.               Created
 * -------------------------------------------------------------------------
*******************************************************************************************************************/


package com.metro.distance.calculator;

import org.springframework.stereotype.Component;

@Component
public class DistanceCalculator {

	/**
	 * Function created for providing the distance between two points based on
	 * the latitude and longitude. Since, it was aerial travel the elevations
	 * were not considered
	 */
	public double distance(double latitude1, double longitude1, double latitude2, double longitude2) {
		// Radius of the earth
		double R = 6371;
		double dLat = Math.toRadians(latitude1 - latitude2);
		double dLon = Math.toRadians(longitude1 - longitude2);

		// As per the haversign formula
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(Math.toRadians(latitude2))
				* Math.cos(Math.toRadians(latitude1)) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		return R * c;
	}
	

}
