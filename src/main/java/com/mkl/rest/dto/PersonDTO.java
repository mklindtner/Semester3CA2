package com.mkl.rest.dto;

import com.mkl.data.entities.Address;
import com.mkl.data.entities.Hobby;
import com.mkl.data.entities.Person;
import com.mkl.data.entities.Phone;

import java.util.HashSet;
import java.util.Set;

public class PersonDTO implements BaseDTOMapper<Person, PersonDTO>
{
	private String firstName, lastName, email;
	private Set<HobbyDTO> hobbies;
	private AddressDTO    addresses;
	private Set<PhoneDTO> phones;

	private PersonDTO(
			String firstName, String lastName, AddressDTO addressDTO, Set<HobbyDTO> hobbyDTO, Set<PhoneDTO>
			phones)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.addresses = addressDTO;
		this.hobbies = hobbyDTO;
		this.phones = phones;
	}

	public PersonDTO()
	{
	}

	@Override public PersonDTO apply(Person person)
	{
		return fullPerson(person);
	}

	public static PersonDTO fullPerson(Person p)
	{
		Set<HobbyDTO> hobbyDTOSet   = hobbyToHobbyDTO(p.getHobbies());
		Address       personAddress = p.getAddress();
		Set<PhoneDTO> phoneDTOSet   = phoneToPhoneDTO(p.getPhones());
		return new PersonDTO(p.getFirstName(), p.getLastName(), AddressDTO.basic(personAddress), hobbyDTOSet, phoneDTOSet);
	}

	private static Set<HobbyDTO> hobbyToHobbyDTO(Set<Hobby> hobbies)
	{
		Set<HobbyDTO> hobbyDTOSet = new HashSet<>();

		for (Hobby h : hobbies) {
			hobbyDTOSet.add(HobbyDTO.basic(h));
		}
		return hobbyDTOSet;
	}

	private static Set<PhoneDTO> phoneToPhoneDTO(Set<Phone> phones)
	{
		Set<PhoneDTO> phoneDTOSet = new HashSet<>();

		for (Phone p : phones) {
			phoneDTOSet.add(PhoneDTO.basic(p));
		}
		return phoneDTOSet;
	}
}
