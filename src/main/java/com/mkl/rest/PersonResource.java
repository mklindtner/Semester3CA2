package com.mkl.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mkl.data.JpaConnection;
import com.mkl.data.entities.InfoEntity;
import com.mkl.data.entities.Person;
import com.mkl.data.repositories.SharedQueriesRepository;
import com.mkl.logic.facades.PersonFacade;
import com.mkl.logic.facades.SharedQueriesFacade;
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
	private SharedQueriesFacade sharedQueriesFacade = new SharedQueriesFacade(JpaConnection.getEntityManagerFactory());
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


	@GET
	@Path("hobby/{hobbyName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPersonsByHobby(@PathParam("hobbyName") String hobbyName) {
		Set<Person> persons = personFacade.getPersonByHobby(hobbyName);
		return Response.ok(gson.toJson(new PersonDTO().convertToSet(persons))).build();
	}

	@GET
	@Path("city/{zipCode}")
	public Response getPersonsByZipcode(@PathParam("zipCode") int zipCode) {
		Set<Person> persons = personFacade.getPersonByZipcode(zipCode);
		return Response.ok(gson.toJson(new PersonDTO().convertToSet(persons))).build();
	}

	@GET
	@Path("hobby/count/{hobbyName}")
	public Response getPersonCountByName(@PathParam("hobbyName") String hobbyName) {
		return Response.ok(gson.toJson(personFacade.getPersonCountByHobby(hobbyName))).build();
	}

	/*
	@GET
	@Path("{phoneNumber}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPersonByPhoneNumber(@PathParam("phoneNumber") int phoneNumber)
	{
		//Person     p    = personFacade.getPersonByPhoneNumber(phoneNumber);
		InfoEntity p    = sharedQueriesFacade.findPersonOrCompanyByPhone(phoneNumber);
		PersonDTO  pDTO = PersonDTO.fullPerson((Person) p);
		return Response.ok(gson.toJson(pDTO)).build();
	} */

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createPerson(String content)
	{
		return baseRest.post(content);
	}





}
