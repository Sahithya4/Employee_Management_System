package com.employee.repository;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bank.entity.Employee;

public class ListReportingManager {

	public ArrayList<String> listReportingManager(Employee employee) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Emp_bank");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		ArrayList<String> resultList = null;
		try {
			entityManager.getTransaction().begin();
			String rep = employee.getReportingmanager();
			System.out.println(rep);
			String queryString = "SELECT employeename FROM Employee where reportingmanager='" + rep + "'";
			Query query = entityManager.createQuery(queryString);
			resultList = (ArrayList<String>) query.getResultList();
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		return resultList;

	}

}
