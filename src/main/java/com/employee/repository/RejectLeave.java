package com.employee.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bank.entity.Leave;

public class RejectLeave {

	public String rejectLeave(Leave leave) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Emp_bank");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Leave leaves = entityManager.find(Leave.class, leave.getLeaveid());
			leaves.setStatus("Rejected");//status will be updated to rejected
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		return "Rejected";
	}

}
