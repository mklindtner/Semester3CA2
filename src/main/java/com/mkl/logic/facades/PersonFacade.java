package com.mkl.logic.facades;

import com.mkl.data.entities.Person;
import com.mkl.data.repositories.PersonRepository;

import javax.persistence.EntityManagerFactory;
import java.util.Set;

public class PersonFacade implements Facade<Person>
{

	private PersonRepository personRepository;
	public PersonFacade(EntityManagerFactory emf) {
		personRepository = new PersonRepository(emf);
	}

	@Override public Set<Person> get()
	{
		return personRepository.getAllPerson();
	}

	@Override public Person get(int id)
	{
		return personRepository.getPersonById(id);
	}

	@Override public Person put(Person object)
	{
		throw new UnsupportedOperationException("lol");
	}

	@Override public Person post(Person object)
	{
		return personRepository.createPerson(object);
	}

	@Override public Person delete(int id)
	{
		throw new UnsupportedOperationException("lol more");
	}
}
