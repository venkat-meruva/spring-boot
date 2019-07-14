package com.services.hateoas.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.services.hateoas.model.User;

/**
 * Controller class where rest end point is created
 * @author Venkat
 *HATEOAS. Hypermedia As The Engine Of Application State (HATEOAS) 
 */
@RestController
public class UserController {

	@RequestMapping("/all")
	public List<User> getAll(){
		User user1 = new User("venkat", 4500L);
		User user2 = new User("meruva", 2400L);
		return Arrays.asList(user1,user2 );
	}
	
	@RequestMapping(value ="/hateoas/all", produces = MediaTypes.HAL_JSON_VALUE)
	public List<User> getHateoasAll(){
		User user1 = new User("venkat", 4500L);
		Link link= ControllerLinkBuilder.linkTo(UserController.class).slash(user1.getName()).withSelfRel();
		user1.add(link);
		User user2 = new User("meruva", 2400L);
		user2.add(link);
		return Arrays.asList(user1,user2 );
	}
	
}
