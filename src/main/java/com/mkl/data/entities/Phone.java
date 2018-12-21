package com.mkl.data.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "phone")
public class Phone
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private int number;
	@Column
	private String description;

	@ManyToOne
	@JoinColumn(name="infoEntity_id", nullable = false)
	private InfoEntity infoEntities;


	public Phone()
	{
	}

	public int getId()
	{
		return this.id;
	}

	public int getNumber()
	{
		return this.number;
	}

	public String getDescription()
	{
		return this.description;
	}

	public InfoEntity getInfoEntities()
	{
		return this.infoEntities;
	}
}
