package com.mmelo.hospitalsecurity.repository;

import com.mmelo.hospitalsecurity.repository.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}