package com.mkl.rest.dto;

import com.mkl.data.entities.Hobby;

public class HobbyDTO implements BaseDTOMapper<Hobby, HobbyDTO>
{
	private int id;
	private String name, description;

	public HobbyDTO(int id, String name, String description)
	{
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public HobbyDTO()
	{
	}

	@Override public HobbyDTO apply(Hobby hobby)
	{
		return basic(hobby);
	}

	public static HobbyDTO basic(Hobby hobby) {
		return new HobbyDTO(hobby.getId(), hobby.getName(), hobby.getDescription());
	}
}
