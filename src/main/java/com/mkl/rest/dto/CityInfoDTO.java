package com.mkl.rest.dto;

import com.mkl.data.entities.Address;
import com.mkl.data.entities.CityInfo;

import java.util.HashSet;
import java.util.Set;

public class CityInfoDTO implements BaseDTOMapper<CityInfo, CityInfoDTO>
{
	private int id, zipcode;
	private String          city;
	private Set<AddressDTO> addresses;

	public CityInfoDTO()
	{
	}

	private CityInfoDTO(int id, int zipcode, String city, Set<AddressDTO> addresses)
	{
		this.id = id;
		this.zipcode = zipcode;
		this.city = city;
		this.addresses = addresses;
	}

	@Override public CityInfoDTO apply(CityInfo cityInfo)
	{
		return full(cityInfo);
	}

	public static CityInfoDTO full(CityInfo cityInfo)
	{
		Set<Address>    addresses   = cityInfo.getAddresses();
		Set<AddressDTO> addressDTOS = new HashSet<>();
		for (Address a : addresses) {
			addressDTOS.add(AddressDTO.basic(a));
		}
		return new CityInfoDTO(cityInfo.getId(), cityInfo.getZipcode(), cityInfo.getName(), addressDTOS);
	}

	public int getZipcode()
	{
		return this.zipcode;
	}
}
