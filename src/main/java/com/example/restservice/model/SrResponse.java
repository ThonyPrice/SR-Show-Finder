package com.example.restservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class for SR's API respone.
 *
 * Mapper for top level JSON.
 * Find documentation of API at https://sverigesradio.se/api/documentation/v2/metoder/program.html
 * The properties was generated at https://www.site24x7.com/tools/json-to-java.html
 * using the response from https://api.sr.se/api/v2/programs/index?format=json&pagination=false
 * */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SrResponse {
	private String copyright;
	private Show[] shows;

	// Getter Methods 

	public String getCopyright() {
		return copyright;
	}

	@JsonProperty("programs")
	public Show[] getShows() {
		return shows;
	}

	// Setter Methods 

	public void setCopyright( String copyright ) {
		this.copyright = copyright;
	}

	@JsonProperty("programs")
	public void setShows( Show[] shows ) {
		this.shows = shows;
	}

	@Override
	public String toString() {
		return "SrResponse [Copyright=" + copyright + ", Shows=" + shows.toString() + "]";
	}
}
