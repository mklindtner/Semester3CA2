package com.mkl.logic.facades;

import com.mkl.data.entities.Company;
import com.mkl.data.repositories.CompanyRepository;

import javax.persistence.EntityManagerFactory;
import java.util.Set;

public class CompanyFacade implements Facade<Company>
{
	private CompanyRepository companyRepository;
	public CompanyFacade(EntityManagerFactory emf) {
		companyRepository = new CompanyRepository(emf);
	}

	@Override public Set<Company> get()
	{
		return companyRepository.getCompanies();
	}

	@Override public Company get(int id)
	{
		return companyRepository.getCompanyById(id);
	}

	@Override public Company put(Company object)
	{
		throw new UnsupportedOperationException("lollz");
	}

	@Override public Company post(Company object)
	{
		return companyRepository.createCompany(object);
	}

	@Override public Company delete(int id)
	{
		throw new UnsupportedOperationException("lol");
	}

	public Set<Company> getByNumOfEmployees(int employeeAmount)
	{
		return companyRepository.getCompaniesByEmployeeNumber(employeeAmount);
	}
}
