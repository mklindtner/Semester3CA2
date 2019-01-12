package com.mkl.data.entities;

import javax.persistence.*;
import java.util.Objects;
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

	public Address(String street, String information, Set<InfoEntity> infoEntities, CityInfo cityInfo)
	{
		this.street = street;
		this.information = information;
		this.infoEntities = infoEntities;
		this.cityInfo = cityInfo;
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

	@Override public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof Address)) return false;
		Address address = (Address) o;
		return Objects.equals(street, address.street) &&
			   Objects.equals(information, address.information);
	}

	@Override public int hashCode()
	{

		return Objects.hash(street, information);
	}
}
