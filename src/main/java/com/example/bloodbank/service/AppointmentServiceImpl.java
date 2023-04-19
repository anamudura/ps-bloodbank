package com.example.bloodbank.service;

import com.example.bloodbank.appuser.Appointment;
import com.example.bloodbank.dto.AppointmentDto;
import com.example.bloodbank.repo.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService{
    private final AppointmentRepository appointmentRepository;
    @Override
    public Appointment save(AppointmentDto appointmentDto) {
        Appointment app =
                new Appointment(appointmentDto.getBloodtype(),appointmentDto.getDay(),
                        appointmentDto.getMonth(), appointmentDto.getYear());

        return appointmentRepository.save(app);

    }

    @Override
    public Appointment getApp(Long id) {
        return appointmentRepository.getById(id);
    }
}
