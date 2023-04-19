package com.example.bloodbank.repo;

import com.example.bloodbank.appuser.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    Appointment getById(Long id);
}
