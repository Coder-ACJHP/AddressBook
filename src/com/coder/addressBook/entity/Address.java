package com.coder.addressBook.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Address")
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull()
	@Size(min=1, message="is required")
	@Column(name = "firstName")
	private String firstName;

	@NotNull()
	@Size(min=1, message="is required")
	@Column(name = "lastName")
	private String lastName;

	@NotNull()
	@Size(min=1, message="is required")
	@Column(name = "country")
	private String Country;

	@NotNull()
	@Size(min=1, message="is required")
	@Column(name = "city")
	private String city;

	@NotNull()
	@Size(min=1, message="is required")
	@Column(name = "district")
	private String district;

	@NotNull()
	@Size(min=1, message="is required")
	@Column(name = "street")
	private String street;

	@NotNull()
	@Size(min=1, max=6, message="is required")
	@Column(name = "number")
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

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
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

	

	public Address(int id, @NotNull @Size(min = 1, message = "is required") String firstName,
			@NotNull @Size(min = 1, message = "is required") String lastName,
			@NotNull @Size(min = 1, message = "is required") String country,
			@NotNull @Size(min = 1, message = "is required") String city,
			@NotNull @Size(min = 1, message = "is required") String district,
			@NotNull @Size(min = 1, message = "is required") String street,
			@NotNull @Size(min = 1, max = 6, message = "is required") String number) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		Country = country;
		this.city = city;
		this.district = district;
		this.street = street;
		this.number = number;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", Country=" + Country
				+ ", city=" + city + ", district=" + district + ", street=" + street + ", number=" + number + "]";
	}

}
