package com.employee.repository;

import java.util.ArrayList;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bank.entity.Login;

public class Validation {

	public String checkValidate(Login login) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Emp_bank");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Login login1 = entityManager.find(Login.class, login.getName());
		ArrayList<String> resultList = null;
		try {
			if (login1.getName().equals(login.getName()) && login1.getPassword().equals(login.getPassword())
					&& login1.getRole().equals("admin")) {
				System.out.println("admin");
				return "admin";
			}
			if (login1.getName().equals(login.getName()) && login1.getPassword().equals(login.getPassword())
					&& login1.getRole().equals("user")) {
				System.out.println("User");
				entityManager.getTransaction().begin();
				String queryString = "SELECT employeename FROM Employee where reportingmanager='" + login.getName()
						+ "'";
				Query query = entityManager.createQuery(queryString);
				resultList = (ArrayList<String>) query.getResultList();

				entityManager.getTransaction().commit();
			}
		}
		catch(NullPointerException e)
		{
			System.out.println(e);
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e);
		}
		finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		if(resultList==null)
			return "error";
		if (resultList.size() > 0)
			return "manager";
		else
			return "user";

	}

	public static String generatePassword()
   	{
   		int n=9;
   		String x;
		final Random RANDOM = new Random();
	    String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	    String digits="0123456789";
	    String splchar="@!#$%&*?+-";
		StringBuilder returnValue = new StringBuilder(n);
	    for (int i = 0; i < 4; i++) {
	        returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
	    }
	    returnValue.append(digits.charAt(RANDOM.nextInt(digits.length())));
	    returnValue.append(splchar.charAt(RANDOM.nextInt(splchar.length())));
	    returnValue.append(digits.charAt(RANDOM.nextInt(digits.length())));
	    returnValue.append(splchar.charAt(RANDOM.nextInt(splchar.length())));
	    x=returnValue.toString();
		return x;
   	}

}
