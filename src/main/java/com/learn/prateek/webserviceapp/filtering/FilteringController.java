package com.learn.prateek.webserviceapp.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "value3" })

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public SomeBean uriV1() {
		return new SomeBean("value1", "value2", "value3");
	}
}