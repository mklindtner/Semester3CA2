package com.mkl.data.entities;

import org.hibernate.engine.profile.Fetch;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "hobby")
public class Hobby
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToMany(cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE
	})
	@JoinTable(name= "person_hobby",
			   joinColumns = @JoinColumn(name = "hobby_id"),
			   inverseJoinColumns = @JoinColumn(name = "person_id"))
	private Set<Person> persons = new HashSet<>();

	@Column
	private String name;

	@Lob
	@Column(length = 700)
	private String description;

	public Hobby()
	{
	}

	public Set<Person> getPersons()
	{
		return this.persons;
	}

	public void setPersons(Set<Person> persons)
	{
		this.persons = persons;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getId()
	{
		return this.id;
	}
}
