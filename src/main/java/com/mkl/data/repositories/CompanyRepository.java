package com.mkl.data.repositories;

import com.mkl.data.entities.Company;
import com.mkl.data.repositories.genericRepositories.BaseRepository;

import javax.persistence.EntityManagerFactory;
import java.util.Set;

public class CompanyRepository
{
	private BaseRepository<Company, Integer> repo;

	public CompanyRepository(EntityManagerFactory emf)
	{
		this.repo = new BaseRepository<>(Company.class, emf);
	}

	public Set<Company> getCompanies()
	{
		return repo.get();
	}

	public Company getCompanyById(int id)
	{
		return repo.getEntity(id);
	}

	public Company createCompany(Company company)
	{
		return repo.post(company);
	}
}
