package com.naehas.org;

public class Tshirt{
	private String name;
	private String colour;
	private String size;
	private String gender;
	private double price;
	protected double rating;
	private String choice;
	private String id;

	public String getId() {
		return id;
	}
	public String toString() {
		return " [id = " + id + " name = " + name + ", colour = " + colour + ", size = " + size + ", gender = " + gender + ", price = "
				+ price + ", rating = " + rating + "]";
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Tshirt(double price) {
		this.price = price;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getSize() {
		return size;
	}
	public Tshirt(String name, String colour, String size, String gender, double price, double rating,String id) {
		this.name = name;
		this.colour = colour;
		this.size = size;
		this.gender = gender;
		this.price = price;
		this.rating = rating;
		this.id=id;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	public Tshirt() {
	}
}
