package com.example.ps1.appuser.dao;

import com.example.ps1.appuser.Admin;
import com.example.ps1.appuser.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
}
