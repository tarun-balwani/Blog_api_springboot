package com.blog.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entities.User;

// extending to JpaRepository as it will provide all the functionality to access database such as find, create
public interface UserRepo extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);
}
