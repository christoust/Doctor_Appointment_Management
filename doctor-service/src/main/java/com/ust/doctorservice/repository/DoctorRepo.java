package com.ust.doctorservice.repository;

import com.ust.doctorservice.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DoctorRepo extends JpaRepository<Doctor,Integer> {
}
