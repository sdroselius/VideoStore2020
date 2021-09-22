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

class InventoryItemTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private InventoryItem item;

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
		item = em.find(InventoryItem.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		item = null;
	}

	@Test
	void test_InventoryItem_entity_mapping() {
		assertNotNull(item);
		assertEquals(MediaCondition.Used, item.getMediaCondition());
	}
	
	@Test
	void test_InventoryItem_Film_ManyToOne_relationship_mapping() {
		assertNotNull(item);
		assertNotNull(item.getFilm());
		assertEquals(1, item.getFilm().getId());
	}

	@Test
	void test_InventoryItem_Store_ManyToOne_relationship_mapping() {
		assertNotNull(item);
		assertNotNull(item.getStore());
		assertEquals(1, item.getStore().getId());
	}
	
	@Test
	void test_InventoryItem_Rental_OneToMany_relationship_mapping() {
		assertNotNull(item);
		assertNotNull(item.getRentals());
		assertTrue(item.getRentals().size() > 1);
	}
	

	
}
