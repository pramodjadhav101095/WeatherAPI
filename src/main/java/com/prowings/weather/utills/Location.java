package com.prowings.weather.utills;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Location {

	public static Map<String, List<Double>> getlatlong() {

		HashMap<String, List<Double>> latLongCity = new HashMap<>();

		latLongCity.put("Pune", Arrays.asList(18.5204 , 73.8567));

		return Collections.unmodifiableMap(latLongCity);

	}

}
