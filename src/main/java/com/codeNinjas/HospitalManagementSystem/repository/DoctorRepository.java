package com.codeNinjas.HospitalManagementSystem.repository;

import com.codeNinjas.HospitalManagementSystem.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
