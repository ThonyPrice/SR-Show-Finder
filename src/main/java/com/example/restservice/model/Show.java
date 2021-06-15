package com.example.restservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

/**
 * Class for Show - Part of SR's API response.
 *
 * Find documentation of API at https://sverigesradio.se/api/documentation/v2/metoder/program.html
 * The properties was generated at https://www.site24x7.com/tools/json-to-java.html
 * using the response from https://api.sr.se/api/v2/programs/index?format=json&pagination=false
 * */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Show {
	private String description;
	private String broadcastinfo;
	private String name;


	// Getter Methods 

	public String getDescription() {
		return description;
	}

	public String getBroadcastInfo() {
		return broadcastinfo;
	}

	public String getName() {
		return name;
	}

	// Setter Methods 

	public void setDescription( String description ) {
		this.description = description;
	}

	public void setBroadcastInfo( String broadcastinfo ) {
		this.broadcastinfo = broadcastinfo;
	}

	public void setName( String name ) {
		this.name = name;
	}
}
