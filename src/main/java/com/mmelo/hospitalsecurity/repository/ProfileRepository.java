package com.mmelo.hospitalsecurity.repository;

import com.mmelo.hospitalsecurity.repository.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Optional<Profile> findByDescription(final String description);

}