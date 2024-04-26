package com.prowings.weather.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Sys {

	private int type;
    private int id;
    private String country;
    private int sunrise;
    private int sunset;
}
