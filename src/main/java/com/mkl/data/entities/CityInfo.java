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
}
