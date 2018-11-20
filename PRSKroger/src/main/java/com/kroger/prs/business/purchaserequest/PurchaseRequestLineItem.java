package com.kroger.prs.business.purchaserequest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.kroger.prs.business.product.Product;

@Entity
public class PurchaseRequestLineItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	@ManyToOne
	@JoinColumn(name="purchaseRequestID")
	private PurchaseRequest purchaseRequest;
	@ManyToOne
	@JoinColumn(name="productID")
	private Product product;
	private int quantity;
	
	public PurchaseRequestLineItem() {
		id = 0;
		purchaseRequest = null;
		product = null;
		quantity = 0;
	}
	
	public PurchaseRequestLineItem(int inID, PurchaseRequest inPr, Product inPdt, int inQty) {
		id = inID;
		purchaseRequest = inPr;
		product = inPdt;
		quantity = inQty;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PurchaseRequest getPurchaseRequest() {
		return purchaseRequest;
	}
	public void setPurchaseRequest(PurchaseRequest purchaseRequest) {
		this.purchaseRequest = purchaseRequest;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "purchaseRequestLineItem [id=" + id + ", purchaseRequest=" + purchaseRequest + ", product="
				+ product + ", quantity=" + quantity + "]";
	}

}
