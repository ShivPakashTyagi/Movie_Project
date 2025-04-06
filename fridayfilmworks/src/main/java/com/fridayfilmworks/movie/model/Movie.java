package com.fridayfilmworks.movie.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String movieName;
    private String movieType;
    private String leadRole;
    private double budget;
    private String movieTheater;
    private String location;
    private String showTimings;


    public Movie() {
    }

    public Movie(String movieName, String movieType, String leadRole, double budget, String movieTheater, String location, String showTimings) {
        this.movieName = movieName;
        this.movieType = movieType;
        this.leadRole = leadRole;
        this.budget = budget;
        this.movieTheater = movieTheater;
        this.location = location;
        this.showTimings = showTimings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getLeadRole() {
        return leadRole;
    }

    public void setLeadRole(String leadRole) {
        this.leadRole = leadRole;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getMovieTheater() {
        return movieTheater;
    }

    public void setMovieTheater(String movieTheater) {
        this.movieTheater = movieTheater;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getShowTimings() {
        return showTimings;
    }

    public void setShowTimings(String showTimings) {
        this.showTimings = showTimings;
    }
}



