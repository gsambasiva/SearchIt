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
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.search.searchit.model.User;
import com.search.searchit.service.IUserService;
import com.search.searchit.service.impl.UserServiceImpl;
import com.search.searchit.util.Response;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceMock {

	IUserService userService;
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Test Method");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("After Test Method");
	}
	
	@Test
	public void test_createUser() {
		userService = mock(IUserService.class);
		User user  = new User();
		user.setFirstName("sairam");
		user.setLastName("Dammalapati");
		user.setEmail("sairamd@gmail.com");
		user.setPassword("@#qwe");
		Mockito.when(userService.create(user)).thenReturn(new ResponseEntity<Response>(new Response(Boolean.TRUE, "user created sucessfully", user), HttpStatus.OK));
		ResponseEntity<Response> rResponse = userService.create(user);
		assertEquals(HttpStatus.OK, rResponse.getStatusCode());
	}
	@Test
	public void test_getUser() {
		userService = mock(IUserService.class);
		User user  = new User();
		user.setFirstName("sairam");
		user.setLastName("Dammalapati");
		user.setEmail("sairamd@gmail.com");
		user.setPassword("@#qwe");
		Mockito.when(userService.getUser(12l)).thenReturn(new ResponseEntity<Response>(new Response(Boolean.TRUE, "user created sucessfully", user), HttpStatus.OK));
		ResponseEntity<Response> rResponse = userService.getUser(12l);
		assertEquals(HttpStatus.OK, rResponse.getStatusCode());
	}
	
	@Test
	public void test_deleteUser() {
		userService = mock(IUserService.class);
		Mockito.when(userService.delete(12l)).thenReturn(new ResponseEntity<Response>(new Response(Boolean.TRUE, "user deleted sucessfully", null), HttpStatus.OK));
		ResponseEntity<Response> rResponse = userService.delete(12l);
		assertEquals(HttpStatus.OK, rResponse.getStatusCode());
	}	
	
	@Test
	public void test_loginUser() {
		userService = mock(IUserService.class);
		User user  = new User();
		user.setFirstName("sairam");
		user.setLastName("Dammalapati");
		user.setEmail("sairamd@gmail.com");
		user.setPassword("@#qwe");
		Mockito.when(userService.login("sairamdammalapati@gmail.com", "changeIt")).thenReturn(new ResponseEntity<Response>(new Response(Boolean.TRUE, "User validated Sucessfully", user), HttpStatus.OK));
		ResponseEntity<Response> rResponse = userService.login("sairamdammalapati@gmail.com", "changeIt");
		assertEquals(HttpStatus.OK, rResponse.getStatusCode());
	}
	
	@Test
	public void test_updateUser() {
		userService = mock(IUserService.class);
		User user  = new User();
		user.setFirstName("sairam");
		user.setLastName("Dammalapati");
		user.setEmail("sairamd@gmail.com");
		user.setPassword("@#qwe");
		Mockito.when(userService.update(user)).thenReturn(new ResponseEntity<Response>(new Response(Boolean.TRUE, "user updated sucessfully", user), HttpStatus.OK));
		ResponseEntity<Response> rResponse = userService.update(user);
		assertEquals(HttpStatus.OK, rResponse.getStatusCode());
	}	

}
