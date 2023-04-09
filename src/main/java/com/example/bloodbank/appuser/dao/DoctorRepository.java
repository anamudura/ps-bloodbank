package com.example.bloodbank.appuser.dao;

import com.example.bloodbank.appuser.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//ADAUGAT ULTERIOR - FOLOSESTE SECURITATE
@Repository
@Transactional(readOnly = true)
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findByEmail(String email);
}
