package com.example.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository
public class InstituteDao {
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Object[]> yearSum() {
		String hql = "SELECT a.year,sum(a.instituteAmt) FROM Houfincsuplsum a GROUP BY a.year";
		return (List<Object[]>) entityManager.createQuery(hql).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> instituteYearSum(String year) {

		String hql = "SELECT b.instituteName,sum(a.instituteAmt) FROM Houfincsuplsum a left join a.houfincinst b WHERE a.year = ?0 GROUP BY b.instituteName";
		return (List<Object[]>) entityManager.createQuery(hql).setParameter(0, year).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> instituteAvgSum() {

		String hql = "SELECT a.year,round(avg(a.instituteAmt),0) FROM Houfincsuplsum a WHERE a.instituteCode = '08' GROUP BY a.year";
		return (List<Object[]>) entityManager.createQuery(hql).getResultList();
	}

}
