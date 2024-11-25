package com.cdc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdc.entity.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {

}
