package com.prowings.weather.responsedto.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Main {
	
	 private double tempruture;
	    private double feels_like;
	    private double temp_min;
	    private double temp_max;
	    private int humidity;

}
