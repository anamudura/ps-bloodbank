package com.example.bloodbank.appuser.dao;

import com.example.bloodbank.appuser.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
}
