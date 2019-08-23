package com.employee.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import com.bank.entity.Employee;

public class ListOfDepartments {
	
	public  ArrayList<String> listOfDepartments()
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Emp_bank");  
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        ArrayList<String> results=null;
        try {
        entityManager.getTransaction().begin();
        String queryString = "select distinct departmentname from Employee order by departmentname desc";
        Query query = entityManager.createQuery(queryString);
        results = (ArrayList<String>) query.getResultList();
        entityManager.getTransaction().commit();
        }
        finally
        {
        entityManager.close();
        entityManagerFactory.close();
        }
		return results;		
	}

}
