package com.prowings;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.prowings.entity.Employee;

public class EmployeeDao {

	public static void main(String[] args) {

//		Employee emp1 = new Employee();
//
//		emp1.setName("raghu");
//		emp1.setAddress("Pune");
//		emp1.setSalary(130000);
//		
		/*
		 * CASE-I========L2 cache memory is disabled(By-default)============= here we
		 * created two session objects at line 1 and line 2 if we get same object from
		 * the database then first it will check L1 cache memory if obj not found then
		 * it will go to DB... for each session obj two select query will be generated
		 * i.e each time we have to fetch object from database(for each session L1
		 * memory is there..).
		 * 
		 * CASE-II=========L2 cache memory Enabled==============() only one select query
		 * will be generated(as there is no need to go to database it will fetch object
		 * from L2 cache).
		 * 
		 */

		Session session1 = HibernateUtility.getSessionFactory().openSession(); // line 1-----------
		Transaction txn = session1.beginTransaction();
//		session1.save(emp1);
		Employee emp2 = session1.load(Employee.class, 1);
//		Employee emp2 = session1.get(Employee.class, 1);
//		 session1.update("Employee", emp1);
//		txn.commit();
		System.out.println(emp2);
//
//		Session session2 = HibernateUtility.getSessionFactory().openSession();//line 2-------------------
//		Transaction txn1 = session1.beginTransaction();
//		Employee emp3 = session2.get(Employee.class, 1);
//		txn1.commit();
//		System.out.println(emp3);
//		session2.close();
		session1.close();
		HibernateUtility.shutDown();
	}

}
