package com.skilldistillery.jpavideostore.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.internal.build.AllowSysOut;

import com.skilldistillery.jpavideostore.entities.Actor;
import com.skilldistillery.jpavideostore.entities.Film;
import com.skilldistillery.jpavideostore.entities.Language;

public class ActorDaoImpl implements ActorDAO {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");

	@Override
	public Actor create(Actor actor) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(actor);
		em.getTransaction().commit();
		em.close();
		return null;
	}

	@Override
	public Actor update(int actorId, Actor actor) {
		EntityManager em = emf.createEntityManager();
		Actor managed = em.find(Actor.class, actorId);
		if (managed != null) {
			em.getTransaction().begin();
			managed.setFirstName(actor.getFirstName());
			managed.setLastName(actor.getLastName());
			em.flush();
			em.getTransaction().commit();
		}
		em.close();
		return managed;
	}

	@Override
	public boolean destroy(int id) {
		boolean deleted = false;
		EntityManager em = emf.createEntityManager();
		Actor managed = em.find(Actor.class, id);
		if (managed != null) {
			em.getTransaction().begin();
			em.remove(managed);
			em.getTransaction().commit();
			deleted = true;
		}
		em.close();
		return deleted;
	}

	@Override
	public Actor createActorAndFilm(Actor actor, Film film) {
		EntityManager em = emf.createEntityManager();
		
		if (film.getLanguage() == null) {
			film.setLanguage(em.find(Language.class,1));
		}
		actor.addFilm(film);
		
		em.getTransaction().begin();
		em.persist(actor);
		em.getTransaction().commit();
		em.close();
		return actor;
	}

	@Override
	public Actor addNewActorToFilm(Actor actor, int filmId) {
		EntityManager em = emf.createEntityManager();
		Film film = em.find(Film.class, filmId);
		if (film != null) {
			System.out.println("Got film: " + film.getTitle());
			film.addActor(actor);
			em.getTransaction().begin();
			em.persist(actor);
			em.persist(film);
			em.getTransaction().commit();
		}
		em.close();
		return actor;
	}

}
