package com.kiranaher.security;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kiranaher.model.Credential;

public interface CredentialRepository extends JpaRepository<Credential, Integer> {

}
