package com.metro.distance.client;

public class AddressDetails {

	private String addressName;
	private String longitude;
	private String latitude;
	private String type;
	
	public AddressDetails() {
		
	}

	public AddressDetails(String addressName, String longitude, String latitude, String type) {
		this.addressName = addressName;
		this.longitude = longitude;
		this.latitude = latitude;
		this.type = type;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}

