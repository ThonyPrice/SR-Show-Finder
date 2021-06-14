package com.example.restservice.model;

public class SearchResult {

	private final String message;
	private final String name;
	private final String description;
	private final String broadcastinfo;

	        
	public SearchResult(String message,
		            String name,
		            String description,
	                    String broadcastinfo) {
		this.message = message;
		this.name = name;
		this.description = description;
		this.broadcastinfo = broadcastinfo;
	}

	public String getMessage() {
		return message;
	}

	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}

	public String getBroadcastInfo() {
		return broadcastinfo;
	}
}
