package com.learn.prateek.webserviceapp.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * 3 ways to add versioning in our APIs:
 * 1) Using urls :
 * 			/v1/person
 * 			/v2/person
 * 2) Using request parameters
 * 			/person?version=1
 * 			/person?version=2
 * 3) Using request headers
 * 		Declare field in http request header to determine version
 * 
 *
 */
@RestController
public class PersonVersioningController {
		
	/*** Method 1 : Using URL ***/
	@GetMapping("v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Prateek Joshi");
	}
	
	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new PersonV2("Prateek","Joshi");
	}
	
	/*** Method 2 : Using request parameters ***/
	
	@GetMapping(value="/person",params="version=1")
	public PersonV1 personV1UsingParams() {
		return new PersonV1("Prateek Joshi");
	}
	
	@GetMapping(value="/person",params="version=2")
	public PersonV2 personV2UsingParams() {
		return new PersonV2("Prateek","Joshi");
	}
	
	/*** Method 3 : Using request headers ***/
	
	@GetMapping(value="/person",headers="X-API-VERSION=1")
	public PersonV1 personV1UsingHeaders() {
		return new PersonV1("Prateek Joshi");
	}
	
	@GetMapping(value="/person",headers="X-API-VERSION=2")
	public PersonV2 personV2UsingHeaders() {
		return new PersonV2("Prateek","Joshi");
	}
}
