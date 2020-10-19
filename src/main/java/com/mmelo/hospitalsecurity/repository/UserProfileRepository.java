package com.mmelo.hospitalsecurity.repository;

import com.mmelo.hospitalsecurity.repository.entities.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    List<UserProfile> findByUser_emailIgnoreCase(final String email);

}