package com.prowings.weather.utills;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.dozer.CustomConverter;

public class EpochToDateConverter implements CustomConverter {

	@Override
	public Object convert(Object existingDestinationFieldValue, Object sourceFieldValue, Class<?> destinationClass,
			Class<?> sourceClass) {
		if (sourceFieldValue == null)
			return null;
		if (sourceFieldValue instanceof Integer) {
			int source = (Integer) sourceFieldValue;
			return epochToString(source);
		}

		return "Invalid Date";
	}

	public static String epochToString(long epochTime) {
		// Convert epoch time to LocalDateTime
		LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(epochTime), ZoneId.systemDefault());
		// Define the date format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // Customize the format as
		// Format LocalDateTime to string
		String dateString = dateTime.format(formatter);
		return dateString;
	}
}