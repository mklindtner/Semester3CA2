package com.mkl.rest.dto;

import com.mkl.data.entities.Phone;

public class PhoneDTO implements BaseDTOMapper<Phone, PhoneDTO>
{
	private int id, number;
	private String description;

	public PhoneDTO()
	{
	}

	public PhoneDTO(int id, int number, String description)
	{
		this.id = id;
		this.number = number;
		this.description = description;
	}

	@Override public PhoneDTO apply(Phone phone)
	{
		return basic(phone);
	}

	public static PhoneDTO basic(Phone phone) {
		return new PhoneDTO(phone.getId(), phone.getNumber(), phone.getDescription());
	}
}
