package com.mkl.data.entities;

import javax.persistence.*;

@Entity (name = "company")
public class Company extends InfoEntity
{
	@Column
	private String name, description;

	@Column
	private int cvr, numEmployees, marketValue;

	public Company()
	{
	}

	public Company(String name, String description, int cvr, int numEmployees, int marketValue)
	{
		this.name = name;
		this.description = description;
		this.cvr = cvr;
		this.numEmployees = numEmployees;
		this.marketValue = marketValue;
	}

	public String getName()
	{
		return this.name;
	}

	public String getDescription()
	{
		return this.description;
	}

	public int getCvr()
	{
		return this.cvr;
	}

	public int getNumEmployees()
	{
		return this.numEmployees;
	}

	public int getMarketValue()
	{
		return this.marketValue;
	}
}
