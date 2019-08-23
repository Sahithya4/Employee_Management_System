package com.employee.repository;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.bank.entity.*;

public class ListOfEmployee {

	public ArrayList<Employee> listOfEmployee() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Emp_bank");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		ArrayList<Employee> results = null;
		try {
			entityManager.getTransaction().begin();
			TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e order by employeeid",
					Employee.class);
			results = (ArrayList<Employee>) query.getResultList();
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		return results;

	}

	public ArrayList<Employee> listOfEmployeebtw(Float from, Float to) {
		// Employee employee=new Employee();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Emp_bank");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		TypedQuery<Employee> query = entityManager.createQuery(
				"SELECT e FROM Employee e where salary BETWEEN " + from + " and " + to + " order by employeeid",
				Employee.class);
		ArrayList<Employee> results = (ArrayList<Employee>) query.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return results;

	}

}
