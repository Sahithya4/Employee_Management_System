package com.employee.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bank.entity.Leave;

public class ViewLeave {

	public ArrayList<String> viewLeave(String name) {
		System.out.println(name);
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Emp_bank");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		String queryString = "SELECT employeename FROM Employee where reportingmanager='" + name + "'";
		Query query = entityManager.createQuery(queryString);
		ArrayList<String> resultList = (ArrayList<String>) query.getResultList();
		entityManager.getTransaction().commit();
		entityManager.getTransaction().begin();
		Iterator<String> iterator = resultList.iterator();
		ArrayList<Leave> results = null;
		ArrayList<String> result = new ArrayList<>();
		while (iterator.hasNext()) {
			String val = iterator.next();
			// entityManager.find(Leave.class, val).getLeaveid();
			List<Object> list = entityManager
					.createNativeQuery("SELECT * FROM leaves where name=" + (char) 34 + val + (char) 34 + ";")
					.getResultList();
			if (list.isEmpty()) {
			} else {
				for(int i=0;i<list.size();i++) {
				Object[] va = (Object[]) list.get(i);
				System.out.println(Arrays.toString(va));

				result.add(va[0].toString());
				result.add(va[1].toString());
				result.add(va[2].toString());
				result.add(va[3].toString());
				result.add(va[4].toString());
				result.add(va[5].toString());
			}
			}

		} // results = (ArrayList<Leave>) quer.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return result;
	}

}
