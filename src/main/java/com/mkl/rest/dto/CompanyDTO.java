package com.mkl.rest.dto;

import com.mkl.data.entities.Company;

public class CompanyDTO implements BaseDTOMapper<Company, CompanyDTO>
{
	private String name, description;
	private int numEmployees, cvr, marketValue, id;

	private CompanyDTO(String name, String description, int numEmployees, int cvr, int marketValue, int id)
	{
		this.name = name;
		this.description = description;
		this.numEmployees = numEmployees;
		this.cvr = cvr;
		this.marketValue = marketValue;
		this.id = id;
	}

	public CompanyDTO() {}

	@Override public CompanyDTO apply(Company company)
	{
		return full(company);
	}

	public static CompanyDTO full(Company company) {
		return new CompanyDTO(company.getName(), company.getDescription(), company.getNumEmployees(), company.getCvr(),
							  company.getMarketValue(), company.getId());
	}
}
