package com.mkl.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mkl.data.JpaConnection;
import com.mkl.data.entities.Company;
import com.mkl.data.entities.InfoEntity;
import com.mkl.data.entities.Person;
import com.mkl.logic.facades.SharedQueriesFacade;
import com.mkl.rest.dto.CompanyDTO;
import com.mkl.rest.dto.PersonDTO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("infoEntity")
public class SharedQueriesResource
{
	private        SharedQueriesFacade sharedQueriesFacade = new SharedQueriesFacade(JpaConnection.getEntityManagerFactory());
	private static Gson                gson                = new GsonBuilder().setPrettyPrinting().create();


	@GET
	@Path("{phoneNumber}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPersonByPhoneNumber(@PathParam("phoneNumber") int phoneNumber)
	{
		InfoEntity infoEntity = sharedQueriesFacade.findPersonOrCompanyByPhone(phoneNumber);
		PersonDTO  pDTO;
		CompanyDTO cDTO;
		if (infoEntity instanceof Person) {
			pDTO = PersonDTO.fullPerson((Person) infoEntity);
			return Response.ok(gson.toJson(pDTO)).build();
		}
		if(infoEntity instanceof Company) {
			cDTO = CompanyDTO.full((Company) infoEntity);
			return Response.ok(gson.toJson(cDTO)).build();
		}
		return Response.ok(gson.toJson(new String("Unable to find phoneNumber"))).build();
	}
}
