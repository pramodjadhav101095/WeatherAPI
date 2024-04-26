package com.prowings.weather.responsedto.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class WeatherDataDto {
	
	    private Coordinates coordinates;
	    private ArrayList<Weather> weather;
	    private Main main;
	    private int visibility;
	    private Wind wind;
	    private Rain rain;
	    private Clouds clouds;
	    private int dt;
	    private Sys sys;
	    private int id;
	    private String name;

}
