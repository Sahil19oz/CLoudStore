package com.barclays.store.dto;

import com.barclays.store.entity.GeoLocation;

public class GeoLocationDTO {
	private Integer locId;
	private Double latitude;
	private Double longitude;
	
	public GeoLocationDTO() {
		super();
	}
	public GeoLocationDTO(GeoLocation geoLocation) {
		this.locId = geoLocation.getLocId();
		this.latitude = geoLocation.getLatitude();
		this.longitude = geoLocation.getLongitude();
	}
	public Integer getLocId() {
		return locId;
	}
	public void setLocId(Integer locId) {
		this.locId = locId;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
}
