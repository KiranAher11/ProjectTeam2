package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Roles;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Roles, Long> {

	Roles findByRole(String role);
}
