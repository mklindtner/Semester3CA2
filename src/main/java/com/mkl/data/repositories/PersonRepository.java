package com.mkl.data.repositories;

import com.mkl.data.entities.*;
import com.mkl.data.repositories.genericRepositories.BaseRepository;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.sound.sampled.Line;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonRepository
{
	private EntityManagerFactory            emf;
	private BaseRepository<Person, Integer> repo;

	public PersonRepository(EntityManagerFactory emf)
	{
		this.emf = emf;
		this.repo = new BaseRepository<>(Person.class, emf);
	}


	public Set<Person> getAllPerson()
	{
		EntityManager em      = emf.createEntityManager();
		Set<Person>   persons = new HashSet<>();
		try {
			TypedQuery<InfoEntity> query = em.createQuery(
					"Select e FROM infoEntity e where TYPE(e) = person", InfoEntity.class
			); //calls person table and NOT class
			List<InfoEntity> queryResult = query.getResultList();
			for (InfoEntity e : queryResult) {
				persons.add((Person) e);
			}
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e);
		} finally {
			em.close();
			return persons;
		}
	}

	public Set<Person> personsByZipcode(int zipcode) {
		EntityManager em = emf.createEntityManager();
		List<Person> persons = null;
		try {
			TypedQuery<Person> query = em.createQuery("select p from person p where p.address.cityInfo" +
													  ".zipcode=:zipcode", Person.class);
			query.setParameter("zipcode", zipcode);
			persons = query.getResultList();
		} catch(Exception e) {
			e.getStackTrace();
			System.out.println(e);
		} finally {
			em.close();
			return new HashSet<>(persons);
		}
	}



	public Person getPersonById(int id)
	{
		return repo.getEntity(id);
	}

	public Person createPerson(Person p)
	{
		return repo.post(p);
	}

	//test this
	public Set<Person> personsByHobby(String hobbyName)
	{
		EntityManager em      = emf.createEntityManager();
		Set<Person>   persons = new HashSet<>();
		Hobby         hobby   = null;
		try {
			TypedQuery<Hobby> query = em.createQuery("select h from hobby h where h.name=:name", Hobby.class);
			query.setParameter("name", hobbyName);
			hobby = query.getSingleResult();
			if (hobby.getPersons() != null) {
				for (Person p : hobby.getPersons())
					persons.add(p);
			}
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e);
		} finally {
			return new HashSet<>(persons);
		}

	}

	public int personsCountByHobby(String hobbyName)
	{
		EntityManager em = emf.createEntityManager();
		Hobby hobby = null;
		int counter = 0;
		try {
			TypedQuery<Hobby> query = em.createQuery("select h from hobby h where h.name=:name", Hobby.class);
			query.setParameter("name", hobbyName);
			hobby = query.getSingleResult();
			Set<Person> persons = hobby.getPersons();
			for(Person p: persons) {
				counter++;
			}
		} catch(Exception e) {
			e.getStackTrace();
			System.out.println(e);
		} finally {
			em.close();
			//int count = hobby.getPersons().size();
			return counter;
		}
	}

	/*
	public Person getPersonByPhone(int phoneNumber)
	{
		EntityManager em = emf.createEntityManager();
		Person p = null;
		try {
			TypedQuery<Person> query = em.createQuery("Select p FROM person p LEFT JOIN phone ph ON p.id = ph" +
													  ".infoEntities.id WHERE ph.number=:number", Person.class);
			query.setParameter("number", phoneNumber);
			p = query.getSingleResult();
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e);
		} finally {
			em.close();
			return p;
		}
	} */


}
