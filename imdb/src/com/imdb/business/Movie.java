package com.imdb.business;

import java.util.ArrayList;
import java.util.List;

public class Movie implements Identifiable {
	private int id;
	private String title;
	private String plot;
	private String description;
	private String rating;
	private int year;
	private int runtime;
	private String director;
	private List<Genre> genres;
	private List<Actor> actors;
	
	public Movie(int id, String title, String plot, String description, String rating, int year, int runtime,
			String director) {
		this.id = id;
		this.title = title;
		this.plot = plot;
		this.description = description;
		this.rating = rating;
		this.year = year;
		this.runtime = runtime;
		this.director = director;
		genres = new ArrayList<>();
		actors = new ArrayList<>();
	}
	
	public Movie() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getRuntime() {
		return runtime;
	}
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
	
	public void addGenre(Genre g) {
		genres.add(g);
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
	public void addActor(Actor a) {
		actors.add(a);
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", plot=" + plot + ", description=" + description + ", rating="
				+ rating + ", year=" + year + ", runtime=" + runtime + ", director=" + director + "]";
	}
}
