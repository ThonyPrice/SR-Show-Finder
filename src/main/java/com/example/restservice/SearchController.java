package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SearchController {

	private static final String template = "Following results were found in the search term (%s):";

	@GetMapping("/search")
	public SearchResult search(@RequestParam(value = "name", defaultValue = "P3") String name) {
		RadioProgram result = FindMatchingRadioPrograms(name);
		// TODO: Replace the name with actual result when it can be retrieved
		return new SearchResult(String.format(template, name));
	}

	public RadioProgram FindMatchingRadioPrograms(String name) {
		List<RadioProgram> availableRadioPrograms = GetAvailableRadioPrograms();
		// TODO: Compare name to all RadioProgram.name to find matching show, lambda and regex?
		RadioProgram matchingRadioProgram = availableRadioPrograms.get(0);
		return matchingRadioProgram;
	}

	public List<RadioProgram> GetAvailableRadioPrograms() {
	
	        final String uri = "http://api.sr.se/api/v2/programs/index";
 
 	        //TODO: Autowire the RestTemplate in all the examples
 	        RestTemplate restTemplate = new RestTemplate();
 
 	        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(uri, Object[].class);
 	        Object[] objects = responseEntity.getBody();
 	        ObjectMapper mapper = new ObjectMapper();
 	        var obj = Arrays.stream(objects)
		        .map(object -> mapper.convertValue(object, RadioProgram.class))
 	    	        .map(RadioProgram::getName)
			.collect(Collectors.toList());
 
 	        System.out.println(obj);

		// Temporary dummy
		List<RadioProgram> result = new ArrayList<RadioProgram>();
		return result;
	}
}
