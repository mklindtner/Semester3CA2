package com.mkl.data.repositories;

import com.mkl.data.entities.Company;
import com.mkl.data.repositories.genericRepositories.BaseRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class CompanyRepository
{
	private BaseRepository<Company, Integer> repo;
	private EntityManagerFactory emf;

	public CompanyRepository(EntityManagerFactory emf)
	{
		this.emf = emf;
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

	public Set<Company> getCompaniesByEmployeeNumber(int employeeAmount)
	{
		EntityManager em = emf.createEntityManager();
		List<Company> companyList = null;
		try {
			TypedQuery<Company> query = em.createQuery("select c from company c WHERE c.numEmployees > " +
													   ":amount", Company.class);
			query.setParameter("amount", employeeAmount);
			companyList = query.getResultList();
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e);
		} finally {
			em.close();
			return new HashSet<>(companyList);
		}
	}
}
