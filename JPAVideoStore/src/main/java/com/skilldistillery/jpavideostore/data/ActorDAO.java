package com.skilldistillery.jpavideostore.data;

import com.skilldistillery.jpavideostore.entities.Actor;
import com.skilldistillery.jpavideostore.entities.Film;

public interface ActorDAO {
	Actor create(Actor actor);
	Actor update(int actorId, Actor actor);
	boolean destroy(int id);
	Actor createActorAndFilm(Actor actor, Film film);
	Actor addNewActorToFilm(Actor actor, int filmId);
}
