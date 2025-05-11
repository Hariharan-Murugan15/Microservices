package com.cognizant.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cognizant.entity.User;
import com.cognizant.repository.UserRepo;

public class UserServiceTest {
	@InjectMocks
	private UserService userService;
	@Mock
	private UserRepo userRepo;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	public void saveUserTest() {
		User user = new User(0, "haha", "haha@gmail.com");
		when(userRepo.save(user)).thenReturn(user);
		
		User userRes = userService.saveUser(user);
		
		assertEquals("haha@gmail.com", userRes.getEmail());
		verify(userRepo, times(1)).save(user);
	}
}
