package com.mkl.rest.dto;

import com.mkl.data.entities.Address;

public class AddressDTO implements BaseDTOMapper<Address, AddressDTO>
{
	private String street, information;
	private int id;

	private AddressDTO(int id, String street, String information)
	{
		this.id = id;
		this.street = street;
		this.information = information;
	}

	public AddressDTO()
	{
	}

	@Override public AddressDTO apply(Address address)
	{
		return basic(address);
	}

	public static AddressDTO basic(Address address)
	{
		return new AddressDTO(address.getId(), address.getStreet(), address.getInformation());
	}
}
