package com.kiranaher.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiranaher.model.User;

public interface UserRepositoy extends JpaRepository<User, Integer> {


}
