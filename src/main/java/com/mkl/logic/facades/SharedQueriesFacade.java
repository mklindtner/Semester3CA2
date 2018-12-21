package com.mkl.logic.facades;

import com.mkl.data.entities.InfoEntity;
import com.mkl.data.repositories.SharedQueriesRepository;

import javax.persistence.EntityManagerFactory;

public class SharedQueriesFacade
{
	SharedQueriesRepository sharedQueriesRepository;

	public SharedQueriesFacade(EntityManagerFactory emf)
	{
		sharedQueriesRepository = new SharedQueriesRepository(emf);
	}

	public InfoEntity findPersonOrCompanyByPhone(int phoneNumber) {
		return sharedQueriesRepository.personOrCompanyByPhone(phoneNumber);
	}
}
