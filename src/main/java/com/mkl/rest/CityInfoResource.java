package com.mkl.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mkl.data.JpaConnection;
import com.mkl.data.entities.CityInfo;
import com.mkl.logic.facades.CityInfoFacade;
import com.mkl.rest.dto.CityInfoDTO;
import com.mkl.rest.genericRest.BaseRest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashSet;
import java.util.Set;

@Path("cityInfo")
public class CityInfoResource
{
	private        CityInfoFacade cityInfoFacade = new CityInfoFacade(JpaConnection.getEntityManagerFactory());
	private static Gson           gson           = new GsonBuilder().setPrettyPrinting().create();
	private BaseRest<CityInfo, CityInfoDTO> baseRest =
			new BaseRest<>(CityInfo.class, new CityInfoDTO(), cityInfoFacade);


	@GET
	@Path("denmark/zipcodes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response allZipcodesInDenmark() {
		Set<CityInfo> cityInfoSet = cityInfoFacade.get();
		Set<CityInfoDTO> cityInfoDTOSet = new CityInfoDTO().convertToSet(cityInfoSet);
		Set<Integer> zipcodes = new HashSet<>();
		for(CityInfoDTO ciDTO: cityInfoDTOSet) {
			zipcodes.add(ciDTO.getZipcode());
		}
		return Response.ok(gson.toJson(zipcodes)).build();
	}
}
