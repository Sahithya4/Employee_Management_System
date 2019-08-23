package com.employee.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bank.entity.Employee;
import com.bank.entity.Login;

public class AddRepository {

	public String addRepository(Employee employee) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Emp_bank");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(employee);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		return "Success";
	}

	public String addRepository(Login login) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Emp_bank");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(login);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		return login.getPassword();
	}
}
