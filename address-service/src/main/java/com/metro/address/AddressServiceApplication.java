/******************************************************************************************************************
 * Description    :     AddressServiceApplication
 * 						The SpringBootApplication class for Address Service 
 * 						
 * Known Bugs     :     None
 *
 * Modification Log
 * Date                 Author                               Description
 * -------------------------------------------------------------------------
 * Feb, 2018          Infosys  Limited.               Created
 * -------------------------------------------------------------------------
*******************************************************************************************************************/

package com.metro.address;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AddressServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressServiceApplication.class, args);
	
	}
}
