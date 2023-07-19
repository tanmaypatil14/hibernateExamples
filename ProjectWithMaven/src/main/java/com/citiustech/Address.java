package com.citiustech;

import java.util.Date;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "addresses")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	@Column(length = 50, nullable = false)
	private String street;
	@Column(length = 50, nullable = false)
	private String city;
	@Transient
	private double x;

	@Temporal(TemporalType.TIMESTAMP)
	private Date addressUpdated;
	@Lob
	private byte[] image;

	public Address(int addressId, String street, String city, double x, Date addressUpdated, byte[] image) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.x = x;
		this.addressUpdated = addressUpdated;
		this.image = image;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public Date getAddressAdded() {
		return addressUpdated;
	}

	public void setAddressAdded(Date date) {
		this.addressUpdated = date;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", x=" + x
				+ ", addressAdded=" + addressUpdated + ", image=" + Arrays.toString(image) + "]";
	}

}
