package com.coder.addressBook.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Address")
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="city")
	private String city;
	
	@Column(name="district")
	private String district;
	
	@Column(name="street")
	private String street;
	
	@Column(name="number")
	private String number;
	
	
	public Address() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String theCity) {
		this.city = theCity;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public Address(int id, String firstName, String lastName, String theCity, String district, String street,
			String number) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = theCity;
		this.district = district;
		this.street = street;
		this.number = number;
	}


	@Override
	public String toString() {
		return "Address [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", City=" + city
				+ ", district=" + district + ", street=" + street + ", number=" + number + "]";
	}
	
	
	
}
