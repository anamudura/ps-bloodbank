package com.example.ps1.appuser.dao;

import com.example.ps1.appuser.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);

    @Query("SELECT user from Users user left join user.roles role where role.id = :id")
    List<Users> findUserByRole(@Param("id") Long id);

    Users deleteByEmail(String email);

}
