package com.example.bloodbank.repo;

import com.example.bloodbank.appuser.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    Appointment getById(Long id);

//    @Query("SELECT app from Appointment app inner join app.locations loca where  = current_date")
//    List<Appointment> getAppointment(@Param("name") String nume);

    List<Appointment> findByProg(LocalDate prog);
}
