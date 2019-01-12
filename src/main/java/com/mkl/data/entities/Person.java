package com.mkl.data.entities;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
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

	public Person(String firstName, String lastName, Set<Hobby> hobbies)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.hobbies = hobbies;
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



	@Override public String toString()
	{
		return "Person{" +
			   "firstName='" + firstName + '\'' +
			   ", lastName='" + lastName + '\'' +
			   ", hobbies=" + hobbies +
			   ", id=" + id +
			   ", email='" + email + '\'' +
			   '}';
	}

	@Override public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Person)) return false;
		Person person = (Person) o;
		return Objects.equals(firstName, person.firstName) &&
			   Objects.equals(lastName, person.lastName);
	}

	@Override public int hashCode()
	{

		return Objects.hash(firstName, lastName);
	}
}
