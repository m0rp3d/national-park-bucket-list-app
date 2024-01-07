package com.nationalparkbucketlist.backend.userservices;

import com.nationalparkbucketlist.backend.userservices.controller.UserController;
import com.nationalparkbucketlist.backend.userservices.entity.User;
import com.nationalparkbucketlist.backend.userservices.service.UserService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserServicesApplicationTests {

	@Autowired
	private UserController userController;

	@Autowired
	private UserService userService;

	// was for mysql database

	@Mock
	private UserService mockUserService = new UserService();

	@Mock
	private UserController mockUserController = new UserController();

	// cover is only provided with actual calls of those methods, when doesn't count, nor do mocks

	@Test
	public void testGetByEmailAndPasswordController() {

		User user = new User(1, "origin", "origin", "origin@gmail.com");

		// both assertEquals arguments should return long of 1
		// meaning the controller method will return the id of 'user' that exist with the email and password we passed
		assertEquals(user.getId(), userController.getByEmailAndPassword("origin@gmail.com", "origin").getId());

	}

	@Test
	public void testGetByEmailAndPasswordControllerException() {
		String email = "billymays@gmail.com";
		String password = "billymays123";

		// will throw runtimeexception error if user with the listed email and password doesn't exist
		// test will return true
		assertThatThrownBy(() -> userController.getByEmailAndPassword(email, password))
				.isInstanceOf(RuntimeException.class)
				.hasMessageContaining("No user that matches email and password");
	}

	@Test
	@Disabled
	public void testGetByEmailAndPasswordService() {

		User user = new User(1, "origin", "origin", "origin@gmail.com");

		// both assertEquals arguments should return long of 1
		// meaning the service method will return the id of 'user' that exist with the email and password we passed
		assertEquals(user.getId(), userService.getUserByEmailAndPassword("origin@gmail.com", "origin").getId());

	}

	// disabled for now because will create new user
	@Test
	@Disabled
	public void testCreateUser() {

		User user = new User("temp9", "temp9", "temp9@gmail.com");
		userController.createUser(user);


		// both assertEquals arguments should return long of 1
		// meaning the service method will return the id of 'user' that exist with the email and password we passed
		assertEquals(user.getId(), userService.getUserByEmailAndPassword("temp9@gmail.com", "temp9").getId());
	}

	@Test
	//@Disabled
	public void testCreateUserException() {
		User user = new User("temp1234", "temp1234", "temp1234@gmail.com");

		assertThatThrownBy(() -> userController.createUser(user))
				.isInstanceOf(RuntimeException.class)
				.hasMessageContaining("User matches username and password");
	}

	/*
	@Test
	public void testGetIdByUserNameAndPassword() {
		Long tempId = userService.getUserId("origin", "origin");
		//Long tempId2 = userService.getUserId("second", "second");

		assertEquals(1, tempId, "should return id that matches username and password");
		//assertNotEquals(1, tempId2, "should not equal id of one since that matches with another user");
	}

	@Test
	public void willThrowWhenNotMatchingId() {
		User user = new User("second", "second", "second@gmail.com");

		assertThatThrownBy(() -> userService.getUserId(user.getUserName(), user.getPassword()))
				.isInstanceOf(RuntimeException.class)
				.hasMessageContaining("No user that matches username and password");
	}

	@Test
	public void checkIfUserCreatedFromController() {
		User user = new User("second", "second", "second@gmail.com");
		// will work because it will return a user
		User tempUser = userController.createUser(user);

		// won't work because @Mock will not return a user after creating
		//User tempUser2 = mockUserController.createUser(user);

		assertEquals(user.getId(), tempUser.getId());
		Long tempId = tempUser.getId();
		userController.deleteUserById(tempId);

	}

	@Test
	public void willThrowWhenNoUserNameAndOrPassword() {
		User user = new User("second", "second", "second@gmail.com");


		assertThatThrownBy(() -> userService.getUser(user.getUserName(), user.getPassword()))
				.isInstanceOf(RuntimeException.class)
				.hasMessageContaining("No user that matches username and password");
	}

	@Test
	public void testForBooleanNoUserNameAndOrPassword() {
		User user = new User("second", "second", "second@gmail.com");

		boolean exist =userService.checkUserExist(user.getUserName(), user.getPassword());
		assertEquals(false, exist, "This account shouldn't exist so should return false");

	}

	@Test
	public void getUserTest() {

		User theUser = userService.getUser("origin","origin");

		Long id = theUser.getId();

		assertEquals(1, id, "There is an employee with id of 1");
	}

	@Test
	public void checkUserExist() {

		boolean exist = userService.checkUserExist("origin", "origin");

		assertEquals(true, exist, "User matching parameters exists");
	}

	@Test
	public void checkIfUserCreatedFromService() {
		User user = new User("fourth", "fourth", "fourth@gmail.com");
		// service used in when will not actually happen, so this user not created
		when(mockUserService.createUser(user)).thenReturn(user);

		assertEquals(0, user.getId());

		// failed because called with when doesn't actually call method
		// calling mock outside of when will work though
		//verify(mockUserService).createUser(user);
	}

	// will create user and enter into database
	// will verify that mock service was called

	@Test
	public void verifyUserCreatedMethod() {
		User user = new User(6, "fourth", "fourth", "fourth@gmail.com");
		mockUserService.createUser(user);
		verify(mockUserService).createUser(user);
	}

	 */
}
