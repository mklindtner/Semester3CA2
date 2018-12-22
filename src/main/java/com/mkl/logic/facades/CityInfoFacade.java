package com.mkl.logic.facades;

import com.mkl.data.entities.CityInfo;
import com.mkl.data.repositories.CityInfoRepository;

import javax.persistence.EntityManagerFactory;
import java.util.Set;

public class CityInfoFacade implements Facade<CityInfo>
{
	private CityInfoRepository cityInfoRepository;
	public CityInfoFacade(EntityManagerFactory emf)
	{
		cityInfoRepository = new CityInfoRepository(emf);
	}

	@Override public Set<CityInfo> get()
	{
		return cityInfoRepository.getAllCitiesInfo();
	}

	@Override public CityInfo get(int id)
	{
		throw new UnsupportedOperationException("yet to implement");
	}

	@Override public CityInfo put(CityInfo object)
	{
		throw new UnsupportedOperationException("yet to implement");

	}

	@Override public CityInfo post(CityInfo object)
	{
		throw new UnsupportedOperationException("yet to implement");

	}

	@Override public CityInfo delete(int id)
	{
		throw new UnsupportedOperationException("yet to implement");

	}
}
