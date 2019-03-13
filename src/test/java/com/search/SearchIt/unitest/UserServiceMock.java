package com.search.SearchIt.unitest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.search.searchit.model.User;
import com.search.searchit.service.IUserService;
import com.search.searchit.service.impl.UserServiceImpl;
import com.search.searchit.util.Response;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceMock {
	
	@Mock
	User userMock;
	@InjectMocks
	IUserService userService;
	@InjectMocks
	UserServiceImpl serviceImpl;
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Test Method");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("After Test Method");
	}
	
	@Test
	public void createUser() {
		userService = mock(IUserService.class);
		User user  = new User();
		user.setFirstName("sairam");
		user.setLastName("Dammalapati");
		user.setEmail("sairamd@gmail.com");
		user.setPassword("@#qwe");
		when(userService.create(user)).thenReturn(new ResponseEntity(new Response(Boolean.TRUE,"user Created sucessfully",user), HttpStatus.OK));
		serviceImpl = new UserServiceImpl();
		ResponseEntity<Response> rResponse = serviceImpl.create(user);
		assertEquals(rResponse, rResponse);
	}

}
