package com.mkl.data.repositories;

import com.mkl.data.entities.InfoEntity;
import com.mkl.data.entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.sound.sampled.Line;

public class SharedQueriesRepository
{
	private EntityManagerFactory emf;
	public SharedQueriesRepository(EntityManagerFactory emf) {
		this.emf = emf;
	}

	//doesn't work yet
	public InfoEntity personOrCompanyByPhone(int phoneNumber) {
		EntityManager em = emf.createEntityManager();
		InfoEntity        infoEntity  = null;
		try {
			TypedQuery<InfoEntity> query =
					em.createQuery("Select p FROM infoEntity p LEFT JOIN phone ph ON p.id = ph .infoEntities.id WHERE ph.number=:number", InfoEntity.class);
			query.setParameter("number", phoneNumber);
			infoEntity = query.getSingleResult();
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println(e);
		} finally {
			em.close();
			return infoEntity;
		}
	}
}
