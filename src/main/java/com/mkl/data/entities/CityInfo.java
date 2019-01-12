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

	@OneToMany(fetch = FetchType.EAGER)
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

	public CityInfo(int zipcode, String name)
	{
		this.zipcode = zipcode;
		this.name = name;
	}
}
