package com.yc.bean;

import java.io.Serializable;
import java.sql.Date;

public class House implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String title;
	private String description;
	private Double price;
	private Date pubdate;
	private Integer floorage;
	private String contact;
	
	/*private Integer user_id;
	private Integer type_id;
	private Integer street_id;*/
	
	private Users users;
	private HouseType houseType;
	private Street street;
	
	public House(){
	}
	
	public Date getPubdate() {
		return pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

	public House(String title, Double price, Users users, HouseType houseType,
			Street street) {
		super();
		this.title = title;
		this.price = price;
		this.users = users;
		this.houseType = houseType;
		this.street = street;
	}

	public House(Integer id, String title, String description, Double price,
			Date pubdate, Integer floorage, String contact, Users users,
			HouseType houseType, Street street) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.pubdate = pubdate;
		this.floorage = floorage;
		this.contact = contact;
		this.users = users;
		this.houseType = houseType;
		this.street = street;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getFloorage() {
		return floorage;
	}
	public void setFloorage(Integer floorage) {
		this.floorage = floorage;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public HouseType getHouseType() {
		return houseType;
	}
	public void setHouseType(HouseType houseType) {
		this.houseType = houseType;
	}
	public Street getStreet() {
		return street;
	}
	public void setStreet(Street street) {
		this.street = street;
	}
	
	@Override
	public String toString() {
		return "House [id=" + id + ", title=" + title + ", description="
				+ description + ", price=" + price + ", floorage=" + floorage
				+ ", contact=" + contact + ", users=" + users + ", houseType="
				+ houseType + ", street=" + street + "]";
	}
	
	
	
}
