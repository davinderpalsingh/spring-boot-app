package com.davinder.app.ws.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davinder.app.ws.service.UserService;
import com.davinder.app.ws.shared.dto.UserDto;
import com.davinder.app.ws.ui.model.request.UserDetailsRequestModel;
import com.davinder.app.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	UserService userService;

	/*
	 * This method will be invoked when a call is made to /users/{userid} as
	 * indicated by path attribute. produces attribute indicates that this end point
	 * supports response in xml representation.
	 * 
	 */
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
	public UserRest getUser(@PathVariable String id) {

		// ToDo - Write code to fetch user details from database and return to client
		return null;
	}

	/*
	 * @RequestBody annotation is used to map the request body to a Java
	 * object(UserDetailsRequestModel) This mapping of json payload to a java object
	 * will be taken care of by Spring Boot Framework.
	 * 
	 * consumes attribute suggests that this web service end point can consume
	 * information in both xml and json format. produces attribute suggests that
	 * this web service end point can respond information back in both xml and json
	 * format.
	 */
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();
		UserDto userDto = new UserDto();
		/*
		 * userDetails contain all the information received from POST request body. Copy
		 * all that information from userDetails to the data transfer object - userDto.
		 */
		BeanUtils.copyProperties(userDetails, userDto);
		UserDto createdUser = userService.createUser(userDto);
		/*
		 * createdUser dto has the information about the newly created user. Copy all
		 * that information to returnValue object so that it can be returned to the
		 * client app.
		 */
		BeanUtils.copyProperties(createdUser, returnValue);
		return returnValue;
	}

	@PutMapping
	public String updateUser() {
		return "update user was called.";
	}

	@DeleteMapping
	public String deleteUser() {
		return "delete user was called.";
	}
}
