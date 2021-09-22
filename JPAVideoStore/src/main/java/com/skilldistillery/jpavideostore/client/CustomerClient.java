package com.skilldistillery.jpavideostore.client;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.jpavideostore.entities.Customer;

public class CustomerClient {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
		EntityManager em = emf.createEntityManager();
		Scanner kb = new Scanner(System.in);
		kb.nextLine();
		Customer cust = em.find(Customer.class, 1);
		kb.nextLine();
		System.out.println(cust);
		
		
		kb.nextLine();
		System.out.println(cust.getRentals());
		
		em.close();
		emf.close();
		kb.close();
	}

}
