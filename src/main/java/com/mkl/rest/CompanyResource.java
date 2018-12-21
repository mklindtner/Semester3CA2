package com.mkl.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mkl.data.JpaConnection;
import com.mkl.data.entities.Company;
import com.mkl.logic.facades.CompanyFacade;
import com.mkl.rest.dto.CompanyDTO;
import com.mkl.rest.genericRest.BaseRest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("company")
public class CompanyResource
{
	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

	private BaseRest<Company, CompanyDTO> baseRest = new BaseRest<>(
			Company.class,
			new CompanyDTO(),
			new CompanyFacade(JpaConnection.getEntityManagerFactory())
	);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCompanies() {
		return baseRest.get();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCompany(String content) {
		return baseRest.post(content);
	}


}
