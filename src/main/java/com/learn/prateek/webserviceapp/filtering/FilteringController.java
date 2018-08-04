package com.learn.prateek.webserviceapp.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*** Controller showing filtering applied on SomeBean object during API calls ***/

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public SomeBean retrieveSomeBean() {
		return new SomeBean("value1","value2","value3");
	}

}
