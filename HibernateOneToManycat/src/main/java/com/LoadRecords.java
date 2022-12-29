package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;


public class LoadRecords {

	public static void main(String[] args) {

		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();		
		// obtains the session
		Session session = sf.openSession();
		session.beginTransaction();
		
		Category c = (Category)session.get(Category.class,1L);
		System.out.println("category="+c);
		System.out.println("=======================");

		List <Product> plist =c.getProducts();
		System.out.println(plist.get(4));
		System.out.println("=======================");
		for(Product p :plist) {
			System.out.println(p);
		}
		session.getTransaction().commit();
		session.close();
		
	}

}
