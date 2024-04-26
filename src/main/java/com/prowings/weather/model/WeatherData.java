package com.prowings.weather.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class WeatherData {
	
	    public Coord coord;
	    public ArrayList<Weather> weather;
	    public String base;
	    public Main main;
	    public int visibility;
	    public Wind wind;
	    public Rain rain;
	    public Clouds clouds;
	    public int dt;
	    public Sys sys;
	    public int timezone;
	    public int id;
	    public String name;
	    public int cod;

}
