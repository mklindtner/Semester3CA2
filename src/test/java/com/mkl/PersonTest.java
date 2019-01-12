package com.mkl;

import com.mkl.data.entities.*;
import com.mkl.data.repositories.PersonRepository;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PersonTest
{
	private EntityManager    em;
	private List<Hobby>   hobbies;
	private List<Person>  persons;
	private List<Address> addresses;
	private List<Phone> phones;
	private List<Company> companies;
	private List<CityInfo> cityInfos;
	private List<InfoEntity> infoEntities;

	@Before public void initialize()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("rest-api-test-pu");
		this.em = emf.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Hobby>  hobbyQuery  = em.createQuery("Select h from hobby h", Hobby.class);
		TypedQuery<Person> personQuery = em.createQuery("Select p from person p", Person.class);
		TypedQuery<Address> addressQuery = em.createQuery("Select a from address a", Address.class);
		TypedQuery<CityInfo> cityInfoQuery = em.createQuery("select c from cityInfo c", CityInfo.class);
		TypedQuery<Phone> phoneQuery = em.createQuery("select p from phone p", Phone.class);
		TypedQuery<Company> companyQuery = em.createQuery("select c from company c", Company.class);
		TypedQuery<InfoEntity> infoEntityQuery = em.createQuery("select ie from infoEntity ie", InfoEntity.class);

		this.hobbies = new ArrayList(hobbyQuery.getResultList());
		this.persons = new ArrayList(personQuery.getResultList());
		this.addresses = new ArrayList(addressQuery.getResultList());
		this.phones = new ArrayList<>(phoneQuery.getResultList());
		this.cityInfos = new ArrayList<>(cityInfoQuery.getResultList());
		this.companies = new ArrayList<>(companyQuery.getResultList());
		this.infoEntities = new ArrayList<>(infoEntityQuery.getResultList());


		em.getTransaction().commit();
	}

	@Test
	public void getPerson()
	{
		Person actual   = em.find(Person.class, 1);
		Person expected = new Person("Nicolai", "Mikkelsen", new HashSet<>(hobbies));
		assertEquals(expected, actual);
	}

	@Test
	public void personRepository() {
		PersonRepository personRepository = new PersonRepository(Persistence.createEntityManagerFactory
				("rest-api-test-pu"));
		Set<Person> personSet = personRepository.getAllPerson();
		assertEquals(new HashSet<>(persons), personSet);
	}

	@Test
	public void getAddress() {
		Address actual = em.find(Address.class, 1);
		CityInfo ci = em.find(CityInfo.class, 1);
		Address expected = new Address("Milanovicvej", "82", new HashSet<>(infoEntities), ci);
		assertEquals(expected, actual);
	}

	//etc, etc... for each repository
	//to persist: I would have to create a single object of each, due to exam I don't have time


}
