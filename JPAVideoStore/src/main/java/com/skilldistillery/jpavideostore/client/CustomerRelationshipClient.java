package com.skilldistillery.jpavideostore.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.jpavideostore.entities.Address;
import com.skilldistillery.jpavideostore.entities.Customer;

public class CustomerRelationshipClient {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
		EntityManager em = emf.createEntityManager();
		
		Customer cust = em.find(Customer.class, 1);
		System.out.println(cust);
//		System.out.println(cust.getAddressId());
//		Address addr = em.find(Address.class, cust.getAddressId());
//		System.out.println(addr);
		
		em.close();
		emf.close();
	}

}
