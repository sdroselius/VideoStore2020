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

class LanguageTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Language lang;

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
		lang = em.find(Language.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		lang = null;
	}

	@Test
	void test_Language_entity_mapping() {
		assertNotNull(lang);
		assertEquals("English", lang.getName());
	}

	@Test
	void test_Language_Film_OneToMany_relationship_mapping() {
		assertNotNull(lang);
		assertNotNull(lang.getFilms());
		assertTrue(lang.getFilms().size() > 0);
//		assertEquals(981, lang.getFilms().size());
	}
	
}
