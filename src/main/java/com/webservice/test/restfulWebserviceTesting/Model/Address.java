package com.webservice.test.restfulWebserviceTesting.Model;
/**
@author sabin
*/

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue
	private long id;
	private String street;
	private String aptNo;
	private String cityState;
	private String zip;

	public Address() {
	}

	public Address(String street, String aptNo, String cityState, String zip) {
		this.street = street;
		this.aptNo = aptNo;
		this.cityState = cityState;
		this.zip = zip;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getAptNo() {
		return aptNo;
	}

	public void setAptNo(String aptNo) {
		this.aptNo = aptNo;
	}

	public String getCityState() {
		return cityState;
	}

	public void setCityState(String cityState) {
		this.cityState = cityState;
	}

	public String getZip() {
		return zip;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", aptNo=" + aptNo + ", cityState=" + cityState + ", zip="
				+ zip + "]";
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}
