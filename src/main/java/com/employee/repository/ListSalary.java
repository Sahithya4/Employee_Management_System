package com.employee.repository;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.bank.entity.Employee;

public class ListSalary {

	public ArrayList<Employee> listSalary() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Emp_bank");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		ArrayList<Employee> results = null;
		try {
			entityManager.getTransaction().begin();
			TypedQuery<Employee> query = entityManager
					.createQuery("SELECT e FROM Employee e where salary between 10000 and 20000", Employee.class);
			results = (ArrayList<Employee>) query.getResultList();
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		return results;

	}
}
