package com.mkl.data.entities;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "person")
public class Person extends InfoEntity
{
	@Column
	private String firstName, lastName;


	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "persons")
	private Set<Hobby> hobbies = new HashSet<>();


	public Person()
	{
	}

	public String getFirstName()
	{
		return this.firstName;
	}

	public String getLastName()
	{
		return this.lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public Set<Hobby> getHobbies()
	{
		return this.hobbies;
	}

	public void setHobbies(Set<Hobby> hobbies)
	{
		this.hobbies = hobbies;
	}

	//TODO: insert relations between hobby and person, create person objects <-- imports.sql
}
