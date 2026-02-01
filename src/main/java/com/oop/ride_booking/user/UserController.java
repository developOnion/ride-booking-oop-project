package com.oop.ride_booking.user;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

	public final UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("")
	public List<User> findAllUsers() {
		return userRepository.findAllUsers();
	}

	@GetMapping("/{id}")
	public User findUserById(@PathVariable Long id) {
		Optional<User> userById = userRepository.findUserById(id);
		if (userById.isEmpty()) {
			throw new UserNotFoundException("User with id " + id + " not found.");
		}
		return userById.get();
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public void createUser(@Valid @RequestBody User user) {
		int updated = userRepository.createUser(user);
		if (updated == 0) {
			throw new RuntimeException("Failed to create user.");
		}
	}


	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("/{id}")
	public void updateUserById(@Valid @RequestBody User user, @PathVariable Long id) {
		int updated = userRepository.updateUserById(user, id);
		if (updated == 0) {
			throw new UserNotFoundException("User with id " + id + " not found.");
		}
	}

	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable Long id) {
		int deleted = userRepository.deleteUserById(id);
		if (deleted == 0) {
			throw new UserNotFoundException("User with id " + id + " not found.");
		}
	}
}
