package com.yc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 地区
 * @author Administrator
 *
 */
public class District implements Serializable{

	private static final long serialVersionUID = 2357515085309895848L;
	
	private Integer id;
	private String name;
	private Street street;
	
	private List<Street> streets = new ArrayList<Street>();
	
	public Street getStreet() {
		return street;
	}
	public void setStreet(Street street) {
		this.street = street;
	}
	public List<Street> getStreets() {
		return streets;
	}
	public void setStreets(List<Street> streets) {
		this.streets = streets;
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
	@Override
	public String toString() {
		return "District [id=" + id + ", name=" + name + ", street=" + street
				+ ", streets=" + streets + "]";
	}
	
	
	
	
	
}
