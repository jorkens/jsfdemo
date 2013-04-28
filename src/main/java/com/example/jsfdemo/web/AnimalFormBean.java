package com.example.jsfdemo.web;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jsfdemo.domain.Animal;
import com.example.jsfdemo.service.AnimalManager;

@SessionScoped
@Named("animalBean")
public class AnimalFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Animal animal = new Animal();

	private ListDataModel<Animal> animals = new ListDataModel<Animal>();

	@Inject
	private AnimalManager am;

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public ListDataModel<Animal> getAllAnimals() {
		animals.setWrappedData(am.getAllAnimals());
		return animals;
	}

	// Actions
	public String addAnimal() {
		am.addAnimal(animal);
		animal = new Animal();
		return "showPersons";
	}

	public String deleteAnimal() {
		Animal animalToDelete = animals.getRowData();
		am.deleteAnimal(animalToDelete);
		return null;
	}
	
	public String editPerson()
	{
		animal = animals.getRowData();
		return "addSimple";
	}
	
}
