package com.davinder.app.ws.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.davinder.app.ws.shared.dto.UserDto;

public interface UserService extends UserDetailsService{

	UserDto createUser(UserDto user); 
}
