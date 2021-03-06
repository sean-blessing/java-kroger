package com.kroger.prs.business.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.kroger.prs.business.vendor.Vendor;
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="vendorID")
	private Vendor vendor;
	//private int vendorID;
	private String partNumber;
	private String name;
	private double price;
	private String unit;
	private String photoPath;
	
	public Product() {
		id = 0;
		vendor = null;
		//vendorID = 0;
		partNumber = "";
		name = "";
		price = 0.0;
		unit = "";
		photoPath = "";
	}
	
	public Product(int inId, Vendor inV, String inVPartNumber, String inName, 
					double inPrice, String inUnit, String inPhotoPath) {
		id = inId;
		vendor = inV;
		//vendorID = inVID;
		partNumber = inVPartNumber;
		name = inName;
		price = inPrice;
		unit = inUnit;
		photoPath = inPhotoPath;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public int getVendorID() {
//		return vendorID;
//	}
//
//	public void setVendorID(int vendorID) {
//		this.vendorID = vendorID;
//	}

	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String vendorPartNumber) {
		this.partNumber = vendorPartNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", vendor=" + vendor + ", partNumber=" + partNumber + ", name="
				+ name + ", price=" + price + ", unit=" + unit + ", photoPath=" + photoPath + "]";
	}
	
}
