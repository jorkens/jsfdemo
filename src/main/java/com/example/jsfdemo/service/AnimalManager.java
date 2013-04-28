package com.example.jsfdemo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.jsfdemo.domain.Animal;

public class AnimalManager {
	private List<Animal> animal_db = new ArrayList<Animal>();
	
	private static int size=0;
	
	public void addAnimal(Animal animal) {
		
		Animal a = get(animal.getId());
		if(a==null){
			Animal newAnimal = new Animal();
			AnimalManager.size++;
			setAnimal(newAnimal,animal);
			newAnimal.setId(AnimalManager.size);
			
			animal_db.add(newAnimal);
		}else
		{
			setAnimal(a,animal);
		}
	}
	
	
	public Animal get(int id)
	{
		for(Animal a: animal_db)
		{
			if(a.getId()==id)
				return a;
		}
		return null;
	}
	public void deleteAnimal(Animal animal) {
		Animal animalToRemove = null;
		for (Animal p : animal_db) {
			if (animal.getPin().equals(p.getPin())) {
				animalToRemove = p;
				break;
			}
		}
		if (animalToRemove != null)
			animal_db.remove(animalToRemove);
	}
	public List<Animal> getAllAnimals() {
		return animal_db;
	}

	private void setAnimal(Animal p, Animal animal)
	{
		p.setName(animal.getName());
		p.setPersonOwner(animal.getPersonOwner());
	}
}