package com.imdb.ui;

import com.imdb.business.Movie;
import com.imdb.db.*;
import com.imdb.util.Console;

public class ImdbApp {

	public static void main(String[] args) {
		
		initialize();
		System.out.println("Welcome to the Imdb App");
		String choice = "";
		while (!choice.equalsIgnoreCase("exit")) {
			displayMenu();
			choice = Console.getString("Enter menu option: ");
			if (choice.equalsIgnoreCase("list")) {
				for(Movie m: MovieDB.getMovies()) {
					System.out.println(m);
				}
				
			}
			
		}
		
		System.out.println("Bye");
	}
	
	private static void displayMenu() {
		System.out.println("Menu:");
		System.out.println("list  - List all movies");
		System.out.println("title - List all movies by title");
		System.out.println("actor - List all movies by actor");
		System.out.println("genre - List all movies by genre");
		System.out.println("get   - Get a movie by id");
		System.out.println("exit  - Exit");
	}
	
	private static void initialize() {
		GenreDB.populateGenres();
		ActorDB.populateActors();
		MovieDB.populateMovies();
		
	}

}
