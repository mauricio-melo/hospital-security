package com.mmelo.hospitalsecurity.repository;

import com.mmelo.hospitalsecurity.repository.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailIgnoreCase(final String email);

}