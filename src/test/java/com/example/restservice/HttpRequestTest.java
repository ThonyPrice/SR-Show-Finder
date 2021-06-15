package com.example.restservice;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.example.restservice.controller.SearchController;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

	@LocalServerPort
	private int port;

	@Autowired
	private SearchController controller;

	@Test
	public void searchShouldReturn200() throws Exception {
		assertThat(this.controller.search("Nyheter P4 Kalmar").getStatusCode().equals(200));
	}

	@Test
	public void searchShouldReturn404() throws Exception {
		assertThat(this.controller.search("invalid query").getStatusCode().equals(404));
	}
}
