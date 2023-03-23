package com.example.ps1.service;

import com.example.ps1.appuser.Role;
import com.example.ps1.appuser.Users;
import com.example.ps1.appuser.dao.DoctorRepository;
import com.example.ps1.appuser.dao.UserRepository;
import com.example.ps1.registration.dto.UserRegDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@Setter
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final DoctorRepository doctorRepository;


    @Override
    public Users save(UserRegDto userRegDto) throws UsernameNotFoundException{

        Users users = new Users(userRegDto.getName(),userRegDto.getEmail(),userRegDto.getPassword(),userRegDto.getLocation(),
                List.of(new Role("ROLE_DONATOR")));

            return userRepository.save(users);

    }

    @Override
    public Users saveDoc(UserRegDto userRegDto) {
        Users users = new Users(userRegDto.getName(),userRegDto.getEmail(),userRegDto.getPassword(),userRegDto.getLocation(),
                List.of(new Role("ROLE_DOCTOR")));

        return userRepository.save(users);
    }

    @Override
    public Users getUser(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<Users> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void delete(String email) {
        userRepository.deleteByEmail(email);
    }

    @Override
    public Users update(Users user) {
        return userRepository.save(user);
    }


    @Override
    public List<Users> getDoctors() {
        return userRepository.findUserByRole(2L);
    }

    @Override
    public Optional<Users> getDocById(Long id) {
        return userRepository.findById(id);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users users = userRepository.findByEmail(email);

        if(users == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(users.getEmail(), users.getPassword(), mapRolesToAuthorities(users.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<com.example.ps1.appuser.Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
