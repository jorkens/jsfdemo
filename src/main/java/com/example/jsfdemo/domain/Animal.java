package com.example.jsfdemo.domain;

import javax.validation.constraints.Size;

public class Animal {
	
	private int id;
	private String name;
	private String race;
	private int personOwner;
	private String pin = "";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	
	public int getPersonOwner() {
		return personOwner;
	}
	public void setPersonOwner(int personOwner) {
		this.personOwner = personOwner;
	}
	@Size(min = 2)
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}

}
