package com.skilldistillery.jpavideostore.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.jpavideostore.entities.Film;
import com.skilldistillery.jpavideostore.entities.Language;

public class FilmClient {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
		EntityManager em = emf.createEntityManager();
		
//		Film film = em.find(Film.class, 1);
//		System.out.println(film);
		
		Film film = new Film();
		film.setTitle("Something 5");
		film.setDescription("A description");

//		Language lang = em.find(Language.class,1);
//		film.setLanguage(lang);   // sets the foreign key language_id to 1 when persisted

		Language lang = new Language();
		lang.setName("Romulan (dialect 1)");
		film.setLanguage(lang);
		
		System.out.println("Before begin()");
		em.getTransaction().begin();
		System.out.println("Before persist()");
//		em.persist(lang);
		em.persist(film);
		System.out.println("Before flush()");
		em.flush();
		System.out.println("Before commit()");
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
