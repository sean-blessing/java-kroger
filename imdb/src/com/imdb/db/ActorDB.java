package com.imdb.db;

import java.time.LocalDate;
import java.util.*;

import com.imdb.business.Actor;
import com.imdb.business.Identifiable;

public class ActorDB extends MasterDB {
	
	private static List<Actor> actors;
	
	public static void populateActors() {
		actors = new ArrayList<>();
		actors.add(new Actor(1,"Mark","Hamill", 1951, "Male"));
		actors.add(new Actor(2,"Keanu","Reeves", 1964, "Male"));
		actors.add(new Actor(3,"Laurence","Fishburne", 1961, "Male"));
		actors.add(new Actor(4,"Paul","Reubens", 1952, "Male"));
		actors.add(new Actor(5,"Tom","Cruise", 1962, "Male"));
		actors.add(new Actor(6,"Rachael","McAdams", 1978, "Female"));
		actors.add(new Actor(7,"Adam","Sandler", 1966, "Male"));
	}
	
	public static Actor get(int id) {
		Actor actor = null;
		for (Actor g: actors) {
			if (g.getId()==id) {
				actor = g;
				break;
			}
		}
		
		return actor;
		
	}
	
	public static List<Actor> getActors() {
		return actors;
	}
	
	/*
	 * Note:  Technically we should add
	 * a try / catch and ensure actor
	 * doesn't already exist
	 */
//	public static Actor add(String g) {
//		//List<? extends Identifiable> idList = actors;
//		Actor actor = new Actor(getNextId(actors), g);
//		actors.add(actor);
//		return actor;
//	}
	
}
