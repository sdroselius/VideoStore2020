package com.skilldistillery.jpavideostore.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Customer cust;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("VideoStore");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		cust = em.find(Customer.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		cust = null;
	}

	@Test
	void test_Customer_entity_mapping() {
		assertNotNull(cust);
		assertEquals("Mary", cust.getFirstName());
		assertEquals("Smithers", cust.getLastName());
	}

	// | 1 | 7 | Mary | Smithers | MARY.SMITH@sdvidcustomer.org | 5 | 1 | 2014-05-25
	// 00:00:00 | 2016-09-16 11:32:19 |
	@Test
	void test_Customer_temporal_mapping() {
		assertNotNull(cust);
		assertNotNull(cust.getCreatedAt());
		assertEquals(2014, cust.getCreatedAt().getYear());
		assertEquals(05, cust.getCreatedAt().getMonthValue());
		assertEquals(25, cust.getCreatedAt().getDayOfMonth());
	}

	@Test
	public void test_Customer_Address_OneToOne_relationship() {
		Address address = cust.getAddress();
		assertEquals("1913 Hanoi Way", address.getStreet());
		assertEquals("", address.getStreet2());
		assertEquals("Sasebo", address.getCity());
		assertEquals("35200", address.getPostalCode());
	}

	@Test
	public void test_Customer_Rental_OneToMany_relationship() {
		assertNotNull(cust);
		assertNotNull(cust.getRentals());
		assertTrue(cust.getRentals().size() > 0);
//		assertEquals(95, cust.getRentals().size());
	}

}
