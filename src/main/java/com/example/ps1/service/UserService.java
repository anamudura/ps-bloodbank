package com.example.ps1.service;

import com.example.ps1.appuser.Users;
import com.example.ps1.registration.dto.UserRegDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService extends UserDetailsService {
    final static String USER_NOT_FOUND_msg = "USER WITH EMAIL %s NOT FOUND";


    Users save(UserRegDto userRegDto);
    Users saveDoc(UserRegDto userRegDto);

    Users update(Users user);

    Users getUser(String email);

    Optional<Users> getUserById(Long id);
    void delete(String email);

    List<Users> getDoctors();

    Optional<Users> getDocById(Long id);




}
