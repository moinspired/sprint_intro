package com.motuma.driverslicense.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.motuma.driverslicense.models.Person;
import com.motuma.driverslicense.repositories.PersonRepository;

@Service
public class PersonService {
	private  PersonRepository personRepo;
	
	public PersonService(PersonRepository personRepo) {
		this.personRepo = personRepo;
	}

	public void addPerson(Person person) {
		personRepo.save(person);
	}
	public List<Person> getPersons(){
		List<Person> persons = personRepo.findAll();
		return persons;
	}
}
