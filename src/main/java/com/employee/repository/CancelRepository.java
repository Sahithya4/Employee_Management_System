package com.employee.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bank.entity.Leave;

public class CancelRepository {

	@SuppressWarnings("unchecked")
	public String cancelRepository(Leave leave) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Emp_bank");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			String queryString = "SELECT leaveid FROM leaves where name='" + leave.getName() + "' and status='pending'";
			Query query = entityManager.createNativeQuery(queryString);
			List<Object> leaveid = query.getResultList();

			Object valu = leaveid.get(0);
			
			leave.setLeaveid((int)valu);
			entityManager.getTransaction().commit();
			entityManager.getTransaction().begin();

			Leave leaves=entityManager.find(Leave.class, leave.getLeaveid());
			entityManager.remove(leaves);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		return "Success";
	}

}
