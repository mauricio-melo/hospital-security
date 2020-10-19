package com.mmelo.hospitalsecurity.repository;

import com.mmelo.hospitalsecurity.repository.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}