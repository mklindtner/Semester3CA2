package com.mkl.data.entities;

import org.hibernate.engine.profile.Fetch;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "infoEntity")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class InfoEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	protected int id;

	@Column
	protected String email;

	@OneToMany(fetch = FetchType.EAGER, mappedBy= "infoEntities")
	private Set<Phone> phones = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "address_id", nullable = false)
	private Address address;

	public InfoEntity()
	{
	}


	public int getId()
	{
		return this.id;
	}

	public String getEmail()
	{
		return this.email;
	}

	public Set<Phone> getPhones()
	{
		return this.phones;
	}

	public Address getAddress()
	{
		return this.address;
	}
}
