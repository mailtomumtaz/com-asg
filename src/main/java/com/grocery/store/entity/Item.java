package com.grocery.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name")
	private String itemName;
	
	@Column(name= "is_grocery")
	private boolean isGrocery;
	
	@Column(name= "price")
	private double itemPrice;

	public Item() {
			}
	
	
	public Item(String itemName, boolean isGrocery, double itemPrice) {
		
		this.itemName = itemName;
		this.isGrocery = isGrocery;
		this.itemPrice = itemPrice;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public boolean getIsGrocery() {
		return isGrocery;
	}

	public void setIsGrocery(boolean itemType) {
		this.isGrocery = itemType;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	
}
