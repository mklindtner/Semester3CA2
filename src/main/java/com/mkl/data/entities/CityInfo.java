package com.mkl.data.entities;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "cityInfo")
public class CityInfo
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private int zipcode;

	@Column
	private String name;

	@OneToMany
	private Set<Address> addresses;

	public CityInfo()
	{
	}

	public Set<Address> getAddresses()
	{
		return this.addresses;
	}

	public int getId()
	{
		return this.id;
	}

	public int getZipcode()
	{
		return this.zipcode;
	}

	public String getName()
	{
		return this.name;
	}


}
