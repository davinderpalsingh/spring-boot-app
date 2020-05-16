package com.davinder.app.ws.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.davinder.app.ws.UserRepository;
import com.davinder.app.ws.io.entity.UserEntity;
import com.davinder.app.ws.service.UserService;
import com.davinder.app.ws.shared.Utils;
import com.davinder.app.ws.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	Utils utils;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDto createUser(UserDto user) {
		/*
		 * findByEmail() is a custom method defined in UserRepository. Before persisting
		 * the new user details in database, we want to ensure that there is no record
		 * already in the Users table with the same email id received in Request body of
		 * the POST api call.
		 */
		if (userRepository.findByEmail(user.getEmail()) != null)
			throw new RuntimeException("Record already exists.");

		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);

		/*
		 * We are encrypting the password supplied in POST call by using Spring Security
		 * Framework support.
		 */
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userEntity.setUserId(utils.generateUserId(30));

		/*
		 * The save method being called below is automatically provided out of the box
		 * by Spring Data JPA.
		 */
		UserEntity newUserCreated = userRepository.save(userEntity);

		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(newUserCreated, returnValue);
		return returnValue;
	}

	/*
	 *	loadUserByUsername() is a method declared in UserDetailsService Interface in
	 *  Spring Security Framework.
	 *  We are definition this method as UserServiceImpl class implements UserService interface which in turn
	 *  extends UserDetailsService interface.   
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
	}
}
