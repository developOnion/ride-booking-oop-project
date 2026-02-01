package com.oop.ride_booking.user;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

	private final JdbcClient jdbcClient;

	public UserRepository(JdbcClient jdbcClient) {
		this.jdbcClient = jdbcClient;
	}

	public List<User> findAllUsers() {
		return jdbcClient.sql("SELECT * FROM USERS;")
				.query(User.class)
				.list();
	}

	public Optional<User> findUserById(Long id) {
		return jdbcClient.sql("SELECT * FROM users WHERE id = ?;")
				.param(id)
				.query(User.class)
				.optional();
	}

	public int createUser(User user) {
		return jdbcClient.sql("INSERT INTO users (id, first_name, last_name, email, phone, dob, gender, created_on)	 VALUES (?,?,?,?,?,?,?,?);")
				.params(List.of(user.getId(), user.getFirstName(),
						user.getLastName(), user.getEmail(),
						user.getPhone(), user.getDob(),
						user.getGender().toString(),
						user.getCreatedOn()))
				.update();
	}

	public int updateUserById(User user, Long id) {
		return jdbcClient.sql("UPDATE users SET first_name = ?, " +
				"last_name = ?, email = ?, phone = ?, dob = ?, gender = ?," +
				" created_on = ?, updated_on = ? WHERE id = ?;")
				.params(List.of(user.getFirstName(),
						user.getLastName(), user.getEmail(),
						user.getPhone(), user.getDob(),
						user.getGender().toString(),
						user.getCreatedOn(), user.getUpdatedOn(), id))
				.update();
	}

	public int deleteUserById(Long id) {
		return jdbcClient.sql("DELETE FROM users WHERE id = ?;")
				.param(id)
				.update();
	}
}
