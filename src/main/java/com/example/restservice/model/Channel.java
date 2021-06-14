package com.example.restservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class for Channel - Nested JSON in SR's API response.
 *
 * Find documentation of API at https://sverigesradio.se/api/documentation/v2/metoder/program.html
 * The properties was generated at https://www.site24x7.com/tools/json-to-java.html
 * using the response from https://api.sr.se/api/v2/programs/index?format=json&pagination=false
 * */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Channel {
	private float id;
	private String name;


	// Getter Methods

	public float getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	// Setter Methods

	public void setId( float id ) {
		this.id = id;
	}

	public void setName( String name ) {
		this.name = name;
	}
}
