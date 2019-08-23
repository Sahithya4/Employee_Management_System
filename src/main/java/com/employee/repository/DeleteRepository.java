package com.employee.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bank.entity.Employee;
import com.bank.entity.Login;

public class DeleteRepository {

	public String deleteRepository(Employee employee) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Emp_bank");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String employeename = null;
		try {
			entityManager.getTransaction().begin();
			Employee employee1 = entityManager.find(Employee.class, employee.getEmployeeid());
			employeename = employee1.getEmployeename();
			entityManager.remove(employee1);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		return employeename;
	}

	public String deleteRepository(Login login) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Emp_bank");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Login login1 = entityManager.find(Login.class, login.getName());
			entityManager.remove(login1);
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		return "Success";
	}

}
