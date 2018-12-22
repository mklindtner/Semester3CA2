package com.mkl.data.repositories;

import javax.persistence.EntityManagerFactory;

public class HobbyRepository
{
	private EntityManagerFactory emf;

	public HobbyRepository(EntityManagerFactory emf)
	{
		this.emf = emf;
	}

}
