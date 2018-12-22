package com.mkl.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mkl.data.JpaConnection;
import com.mkl.data.entities.Company;
import com.mkl.logic.facades.CompanyFacade;
import com.mkl.logic.facades.Facade;
import com.mkl.rest.dto.CompanyDTO;
import com.mkl.rest.genericRest.BaseRest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;

@Path("company")
public class CompanyResource
{
	private static Gson          gson          = new GsonBuilder().setPrettyPrinting().create();
	private        CompanyFacade companyFacade = new CompanyFacade(JpaConnection.getEntityManagerFactory());

	private BaseRest<Company, CompanyDTO> baseRest = new BaseRest<>(
			Company.class,
			new CompanyDTO(),
			companyFacade
	);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCompanies()
	{
		return baseRest.get();
	}

	@GET
	@Path("employees/{amountOfEmployees}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompaniesByAmountOfEmployees(@PathParam("amountOfEmployees") int employeeAmount)
	{
		Set<Company> companySet = companyFacade.getByNumOfEmployees(employeeAmount);
		return Response.ok(gson.toJson(new CompanyDTO().convertToSet(companySet))).build();

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCompany(String content)
	{
		return baseRest.post(content);
	}


}
