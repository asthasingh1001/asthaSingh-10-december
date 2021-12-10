package com.astha.demo.Pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id, price;
	
	private String name, description;
	
	
	public Product(String name, int price, String description) {
		super();
		
		this.name = name;
		this.price = price;
		this.description = description;
		System.out.println("Constructor-1-"+this.id);
	}

	
	public int getId() {
		return id;
	}


	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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


	@Override
	public String toString() {
		return "Product [id=" + id + ", price=" + price + ", name=" + name + ", description=" + description + "]";
	}

}
