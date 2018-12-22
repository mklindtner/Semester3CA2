package com.mkl.data.repositories;

import com.mkl.data.entities.CityInfo;
import com.mkl.data.repositories.genericRepositories.BaseRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class CityInfoRepository
{
	private EntityManagerFactory emf;
	private BaseRepository<CityInfo, Integer> baseRepository;

	public CityInfoRepository(EntityManagerFactory emf)
	{
		this.emf = emf;
		baseRepository = new BaseRepository<>(CityInfo.class, emf);
	}

	public Set<CityInfo> getAllCitiesInfo() {
		EntityManager em = emf.createEntityManager();
		List<CityInfo> cityInfoList = null;
		try {
			TypedQuery<CityInfo> cityInfo = em.createQuery("select ci from cityInfo ci", CityInfo.class);
			cityInfoList = cityInfo.getResultList();
		} catch(Exception e) {
			e.getStackTrace();
			System.out.println(e);
		} finally {
			em.close();
			return new HashSet<>(cityInfoList);
		}
	}
}
