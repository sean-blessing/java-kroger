package com.imdb.db;

import java.time.LocalDate;
import java.util.*;

import com.imdb.business.Movie;
import com.imdb.business.Actor;
import com.imdb.business.Identifiable;

public class MovieDB extends MasterDB {
	
	private static List<Movie> movies;
	
	public static void populateMovies() {
		
		movies = new ArrayList<>();
		Movie m = new Movie(getNextId(movies),"Star Wars Episode V",null,null,"PG",1977,124,"George Lucas");
		m.addActor(ActorDB.get(1));
		m.addGenre(GenreDB.get(2));
		movies.add(m);
		
		m = new Movie(getNextId(movies),"The Matrix",null,null,"PG-13",1999,136,"Wachowski Bros.");
		m.addActor(ActorDB.get(2));
		m.addActor(ActorDB.get(3));
		m.addGenre(GenreDB.get(2));
		movies.add(m);
		
		m = new Movie(getNextId(movies),"Pee Wee's Big Adventure",null,null,"PG",1985,91,"Tim Burton");
		m.addActor(ActorDB.get(4));
		m.addGenre(GenreDB.get(1));
		movies.add(m);
		
		m = new Movie(getNextId(movies),"Mission Impossible",null,null,"PG-13",1996,110,"Brian De Palma");
		m.addActor(ActorDB.get(5));
		m.addGenre(GenreDB.get(3));
		movies.add(m);
	}
	
	public static Movie get(int id) {
		Movie movie = null;
		for (Movie m: movies) {
			if (m.getId()==id) {
				movie = m;
				break;
			}
		}
		
		return movie;
		
	}
	
	public static List<Movie> getMovies() {
		return movies;
	}
	
	/*
	 * Note:  Technically we should add
	 * a try / catch and ensure movie
	 * doesn't already exist
	 */
//	public static Actor add(String g) {
//		//List<? extends Identifiable> idList = movies;
//		Actor movie = new Actor(getNextId(movies), g);
//		movies.add(movie);
//		return movie;
//	}
	
}
