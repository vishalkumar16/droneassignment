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

package com.metro.distance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MetroServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MetroServiceApplication.class, args);
	
	}

}
