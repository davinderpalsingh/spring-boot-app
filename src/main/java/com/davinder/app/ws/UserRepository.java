package com.davinder.app.ws;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.davinder.app.ws.io.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

	/*
	 * custom method. If we want to query or find a record / user whose email id
	 * matches the email id supplied as parameter.
	 * 
	 */
	UserEntity findByEmail(String email);
}
