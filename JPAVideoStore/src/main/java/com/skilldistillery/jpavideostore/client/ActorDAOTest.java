package com.skilldistillery.jpavideostore.client;

import com.skilldistillery.jpavideostore.data.ActorDAO;
import com.skilldistillery.jpavideostore.data.ActorDaoImpl;
import com.skilldistillery.jpavideostore.entities.Actor;
import com.skilldistillery.jpavideostore.entities.Film;

public class ActorDAOTest {

	public static void main(String[] args) {
		ActorDAO dao = new ActorDaoImpl();
		
//		Actor newActor = new Actor("Troy", "McClure");
//		Film newFilm = new Film();
//		newFilm.setTitle("DINOSAURS GONE WILD I");
//		newFilm.setReleaseYear(2021);
		
//		System.out.println(newActor);
//		System.out.println(newFilm);
//		dao.create(newActor);
//		dao.createActorAndFilm(newActor, newFilm);
//		System.out.println(newActor);
//		System.out.println(newFilm);
		
		
		
		Actor newActor = new Actor("Doug", "Donahue");
		int filmId = 507;
		System.out.println(newActor);
		dao.addNewActorToFilm(newActor, filmId);
		System.out.println(newActor);
		
	}

}
