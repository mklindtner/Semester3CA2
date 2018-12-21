package com.mkl.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mkl.data.JpaConnection;
import com.mkl.data.entities.Person;
import com.mkl.logic.facades.PersonFacade;
import com.mkl.rest.dto.PersonDTO;
import com.mkl.rest.genericRest.BaseRest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.Set;


@Path("person")
public class PersonResource
{
	private static Gson                        gson     = new GsonBuilder().setPrettyPrinting().create();
	private PersonFacade personFacade = new PersonFacade(JpaConnection.getEntityManagerFactory());
	private        BaseRest<Person, PersonDTO> baseRest =
			new BaseRest<>(
					Person.class,
					new PersonDTO(),
					personFacade
			);


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPersons()
	{
		Set<Person> persons = personFacade.get();
		return Response.ok(gson.toJson(new PersonDTO().convertToSet(persons))).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createPerson(String content)
	{
		return baseRest.post(content);
	}


}
