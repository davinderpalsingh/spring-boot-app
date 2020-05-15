package com.davinder.app.ws.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.davinder.app.ws.service.UserService;

/**
 * 
 * @author davindersingh
 *
 *         Because we have introduced, Spring Security in our application, all
 *         the web service end points are now secured. In this class, we will
 *         make create User (Http.POST, "/users") end point public by using some
 *         classes / interfaces exposed by Spring Security Framework.
 *         
 *         WebSecurityConfigurerAdapter class comes from Spring Security. 
 * 
 */

/*
 * @EnableWebSecurity allows Spring to find that this is a special class where
 * we are doing some configuring(We are configuring an end point to be
 * public)(it's a @Configuration and, therefore, @Component) and automatically
 * apply the class to the global WebSecurity.Courtesy:
 * https://stackoverflow.com/questions/44671457/what-is-the-use-of-enablewebsecurity-in-spring
 */
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	
	private final UserService userDetailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public WebSecurity(UserService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	/*
	 * We has overridden this method of WebSecurityConfigurerAdapter class. We are configuring in this method that
	 * HttpMethod.POST call for /users end point should be permitted for all whereas all other requests will be 
	 * authenticated ie allowed only to valid users.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, "/users")
		.permitAll()
		.anyRequest().authenticated();//any other request to be authenticated.
	}
	
	/*
	 * In this method we are telling to AuthenticationManagerBuilder class that we are using
	 * BCryptPasswordEncoder for doing password encryption.
	 */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

}
