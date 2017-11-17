package cz.expertkom.ju.springdemo.api.impl;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import cz.expertkom.ju.interfaces.UserService;
import cz.expertkom.ju.interfaces.entity.User;
import cz.expertkom.ju.springdemo.api.TestApi;

public class TestApiImpl implements TestApi {
	
	@Autowired
	private UserService userService;

	@Override
	public Response test(String param) {
		 User user = userService.getUser(param);
		 System.out.println("uživatel: "+user);
		 return Response.ok(user).build();
	}

}
