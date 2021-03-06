package com.learn.prateek.webserviceapp.user;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.learn.prateek.webserviceapp.exception.UserNotFoundException;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService service;
	
	//retrieve all users
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	//retrieve user with specific id
	@GetMapping("/users/{id}")
	public Resource<User> retreiveUser(@PathVariable int id)
	{
		User user = service.findOne(id);
		System.out.println(user);
		if( user == null )
		{
			throw new UserNotFoundException("id: "+ id);
		}
		
		/*** HATEOAS concept ***/
		/* Add a link to retieve user /users/{id} request which will be having url to retrieve all users */
		Resource<User> resource = new Resource<User>(user);			
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel("all-users"));
			
		return resource; 
	}
	
	//create a user
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		URI location = 	ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/remove/{id}")
	public void deleteUser(@PathVariable int id)
	{
		User user = service.deleteById(id);
		if( user == null )
		{
			throw new UserNotFoundException("id: "+ id);
		}
	}
}
