package com.example.bloodbank.service;

import com.example.bloodbank.appuser.Users;
import com.example.bloodbank.registration.dto.UserRegDto;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional
public interface UserService {
    final static String USER_NOT_FOUND_msg = "USER WITH EMAIL %s NOT FOUND";


    Users save(UserRegDto userRegDto);
    Users saveDoc(UserRegDto userRegDto);

    Users update(Users user);

    Users getUser(String email);

    Optional<Users> getUserById(Long id);
    void deleteUser(UserRegDto userRegDto);

    Optional<Users> getDocByid(Long id);

    List<Users> getDoctors();
    List<Users> getDoctors2();

    Optional<Users> getDocById(Long id);

    void updateDoctor(UserRegDto userRegDto);



}
