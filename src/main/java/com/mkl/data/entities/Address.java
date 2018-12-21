package com.mkl.data.entities;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "address")
public class Address
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String street, information;

	@OneToMany(mappedBy = "address")
	private Set<InfoEntity> infoEntities;

	@ManyToOne
	@JoinColumn(name = "city_id", nullable = false)
	private CityInfo cityInfo;


	public Address()
	{
	}

	public String getStreet()
	{
		return this.street;
	}

	public String getInformation()
	{
		return this.information;
	}

	public Set<InfoEntity> getInfoEntities()
	{
		return this.infoEntities;
	}

	public CityInfo getCityInfo()
	{
		return this.cityInfo;
	}

	public int getId()
	{
		return this.id;
	}
}
