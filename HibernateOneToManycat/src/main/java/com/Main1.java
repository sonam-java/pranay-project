package com;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main1 {

	public static void main(String[] args) {


		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();		
		// obtains the session
		Session session = sf.openSession();
		session.beginTransaction();
		
		Category category1 = new Category("computer");
		Product laptop1 = new Product("dell","very good",300);
		Product laptop2 = new Product("apple","very good",400);
		Product laptop3 = new Product("lenovo","very good",200);
		Product laptop4 = new Product("xp","very good",100);
        Product laptop5 = new Product("acer","very good",500);

        List<Product> products1 = new ArrayList<Product>();
        products1.add(laptop1);
        products1.add(laptop2);
        products1.add(laptop3);
        products1.add(laptop4);
        products1.add(laptop5);
        
        category1.setProducts(products1);
        session.save(category1);
        
        
        session.getTransaction().commit();
		session.close();
		
		
	}

}
