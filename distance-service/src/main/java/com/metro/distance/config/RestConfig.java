/******************************************************************************************************************
 * Description    :     RestConfig
 * 						The configuration class for RestOperations used in client creation 
 * 						
 * Known Bugs     :     None
 *
 * Modification Log
 * Date                 Author                               Description
 * -------------------------------------------------------------------------
 * Feb, 2018          Infosys  Limited.               Created
 * -------------------------------------------------------------------------
*******************************************************************************************************************/

package com.metro.distance.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {
	
	
	//Creating the implement of the RestOperations used. We are using the RestTemplate implementation
	@Bean
	public RestOperations createRestTemplate(final ClientHttpRequestFactory clientHttpRequestFactory) {
		return new RestTemplate(clientHttpRequestFactory);
	}
	
	//Method created for setting the connection and the read timeouts
	@Bean
	public ClientHttpRequestFactory createClientHttpRequestFactory(@Value("${connect.timeout}") final int connectTimeout,@Value("${read.timeout}") final int readTimeout ) {
		HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		httpComponentsClientHttpRequestFactory.setConnectTimeout(connectTimeout);
		httpComponentsClientHttpRequestFactory.setReadTimeout(readTimeout);
		return httpComponentsClientHttpRequestFactory;
		
	}
}
