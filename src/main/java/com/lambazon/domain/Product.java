package com.lambazon.domain;

public class Product {
	
	private Integer id;
	private String name, description, details;
	private int quantity;
	private double price;

	public Product(int id, int quantity, double price, String name, String description) {
		setId(id);
		setQuantity(quantity);
		setPrice(price);
		setName(name);
		setDescription(description);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getQuantity() {
		return quantity;
	}

	/*
	Modification of the setQuantity method.
	A quantity can not be negative.
	If the quantity passed is negative then it is assigned the value 0 otherwise it is concorded
	 */
	public void setQuantity(int quantity) {
		if (quantity < 0 )
			this.quantity = 0;
		else
			this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}
	/*
	Changing the setPrice method
	The price can not be negative .-> If the price passed is negative then it is assigned the value 0 otherwise it is concerved
	The price can not be> 1000 -> If the price passed is> 1000 then it is assigned the price of 1000
	 */
	public void setPrice(double price) {
		if ( price < 0 )
			this.price = 0;
		else if (price > 1000)
			this.price = 1000;
		else
			this.price = price;
	}
	/*
    Bug fix of inventory value:
    @return -> multiplication of the value returned by the getQuantity method by the value returned by the getPrice method
     */
	public double getInventoryPrice() {

		return getQuantity() * getPrice();
	}
}
