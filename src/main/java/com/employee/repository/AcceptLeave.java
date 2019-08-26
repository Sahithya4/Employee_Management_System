package com.employee.repository;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bank.entity.Leave;

public class AcceptLeave {

	public String acceptLeave(Leave leave) {
		// TODO Auto-generated method stub
		
		//Accepting leave request
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Emp_bank");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Leave leaves = entityManager.find(Leave.class, leave.getLeaveid());
			leaves.setStatus("Accepted"); // updating Leaves and status to accepted
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		return "Accepted";
	}

}
