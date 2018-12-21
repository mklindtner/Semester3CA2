package com.mkl.data.repositories;

import com.mkl.data.entities.Hobby;
import com.mkl.data.entities.InfoEntity;
import com.mkl.data.entities.Person;
import com.mkl.data.repositories.genericRepositories.BaseRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
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
		} catch(Exception e) {
			e.getStackTrace();
			System.out.println(e);
		} finally {
			em.close();
			return persons;
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



}