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

class FilmTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Film film;

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
		film = em.find(Film.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		film = null;
	}

	@Test
	void test_Film_entity_mapping() {
		assertNotNull(film);
		assertEquals("ACADEMY DINOSAUR", film.getTitle());
	}
	
	@Test
	void test_Film_rating_enumerated_type() {
		assertNotNull(film);
		assertNotNull(film.getRating());
		assertEquals(Rating.PG, film.getRating());
	}

	@Test
	void test_Film_Language_ManyToOne_relationship_mapping() {
		assertNotNull(film);
		assertNotNull(film.getLanguage());
		assertEquals("Japanese", film.getLanguage().getName());
	}
	
	@Test
	void test_Film_Actor_ManyToMany_relationship_mapping() {
		assertNotNull(film);
		assertNotNull(film.getActors());
		assertTrue(film.getActors().size() > 0);
//		assertEquals(10, film.getActors().size());
	}
	
	@Test
	void test_Film_Category_ManyToMany_relationship_mapping() {
		assertNotNull(film);
		assertNotNull(film.getCategories());
		assertTrue(film.getCategories().size() > 0);
//		assertEquals(1, film.getCategories().size());
	}
	
	@Test
	void test_Film_InventoryItem_OneToMany_relationship_mapping() {
		assertNotNull(film);
		assertNotNull(film.getItems());
		assertTrue(film.getItems().size() > 0);
	}
	
	
	
}
