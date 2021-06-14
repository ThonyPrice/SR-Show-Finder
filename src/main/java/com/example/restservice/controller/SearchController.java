package com.example.restservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

import com.example.restservice.model.Show;
import com.example.restservice.model.SearchResult;
import com.example.restservice.model.SrResponse;
import com.example.restservice.RestServiceApplication;

/**
 * Provides a RESTful API to search for shows from SR's API.
 *
 * The search is recieved on application endpoint {applicationUrl}/search.
 * A list of all avaialabe shows are fetched from SR's API and compared to the search.
 * On a literal match the requesting party is served information about the show.
 * */
@RestController
public class SearchController {

	private static final Logger log = LoggerFactory.getLogger(RestServiceApplication.class);
	private static final String srUri = "https://api.sr.se/api/v2/programs/index?format=json&pagination=false";
	private static final String templateShowFound = "The following show matched the search term '%s':";
	private static final String templateShowNotFound = "No results found - Try a different search term";

	/**
	 * Endpoint for searching a show
	 * @param	name		The search query
	 * @return	SearchResult	JSON formatted info of search result
	 * */
	@GetMapping("/search")
	public ResponseEntity<?> search(@RequestParam(value = "name", defaultValue = "Så funkar det") String name) {
		log.info(String.format("==== Request to search for shows matching '%s' =======", name));
		Show result = FindMatchingShows(name);
		return FormatSearchResult(name, result);
	}

	/**
	 * Format search result for if match was found or not.
	 * @param	name		The search query
	 * @param	result		The search result
	 * @return	SearchResult	JSON formatted info of search result
	 * */
	public ResponseEntity<?> FormatSearchResult(String name, Show result) {
		if (result == null) {
			return new ResponseEntity<>(
				new SearchResult(templateShowNotFound, null, null, null),
				HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(
				new SearchResult(String.format(templateShowFound, name), 
				result.getName(), result.getDescription(), result.getBroadcastInfo()),
				HttpStatus.OK);
	}

	/**
	 * Determine any literal matches of a string and available shows.
	 * @param	name		The search query
	 * @return	Show		Show object (if match found), else null
	 * */
	public Show FindMatchingShows(String name) {
		Show[] availableShows = GetAvailableShows();
		for (Show show : availableShows) {
			if (show.getName().toLowerCase().equals(name.toLowerCase())) {
				return show;
			}
		}
		log.info(String.format("==== No show matching '%s' was found =======", name));
		return null;
	}

	/**
	 * Fetch all available show through SR's API.
	 * @return	Shows		A list of all shows from API
	 *
	 * Find the complete API documentation at https://sverigesradio.se/api/documentation/v2/
	 * */
	public Show[] GetAvailableShows() {
		RestTemplate restTemplate = new RestTemplate();
		SrResponse response = restTemplate.getForObject(srUri, SrResponse.class);
		log.info("==== Fetched RESTful API from SR =======");
		return response.getShows();
	}
}