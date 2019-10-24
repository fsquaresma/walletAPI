package com.wallet.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.wallet.entity.User;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class UserRepositoryTest {
	
	private static final String EMAIL = "email@test.com";

	@Autowired
	UserRepository repository;
	
	@BeforeEach
	public void setUp() {
		User user = new User();
		
		user.setName("setup user");
		user.setPassword("123setup");
		user.setEmail(EMAIL);
		
		repository.save(user);
	}
	
	@AfterEach
	public void tearDown() {
		repository.deleteAll();
	}
	
	@Test
	public void testSave() {
		User user = new User();
		
		user.setName("Teste");
		user.setPassword("123456");
		user.setEmail(EMAIL);
		
		User response = repository.save(user);
		
		assertNotNull(response);
	}
	
	@Test
	public void testFindByEmail() {
		Optional<User> response = repository.findByEmailEquals(EMAIL);
		
		assertTrue(response.isPresent());
		assertEquals(response.get().getEmail(), EMAIL);
	}
	
}
