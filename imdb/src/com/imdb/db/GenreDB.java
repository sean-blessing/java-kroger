package com.imdb.db;

import java.util.*;

import com.imdb.business.Genre;
import com.imdb.business.Identifiable;

public class GenreDB extends MasterDB {
	
	private static List<Genre> genres;
	
	public static void populateGenres() {
		genres = new ArrayList<>();
		genres.add(new Genre(1,"Comedy"));
		genres.add(new Genre(2,"Sci-Fi"));
		genres.add(new Genre(3,"Action"));
		genres.add(new Genre(4,"Drama"));
		genres.add(new Genre(5,"Kids"));
	}
	
	public static Genre get(int id) {
		Genre genre = null;
		for (Genre g: genres) {
			if (g.getId()==id) {
				genre = g;
				break;
			}
		}
		
		return genre;
		
	}
	
	public static List<Genre> getGenres() {
		return genres;
	}
	
	/*
	 * Note:  Technically we should add
	 * a try / catch and ensure genre
	 * doesn't already exist
	 */
	public static Genre add(String g) {
		//List<? extends Identifiable> idList = genres;
		Genre genre = new Genre(getNextId(genres), g);
		genres.add(genre);
		return genre;
	}
	
}
