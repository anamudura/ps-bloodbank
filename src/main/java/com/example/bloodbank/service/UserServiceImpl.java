package com.example.bloodbank.service;

import com.example.bloodbank.appuser.Role;
import com.example.bloodbank.appuser.Users;
import com.example.bloodbank.appuser.dao.DoctorRepository;
import com.example.bloodbank.appuser.dao.RoleRepository;
import com.example.bloodbank.appuser.dao.UserRepository;
import com.example.bloodbank.registration.dto.UserRegDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@Setter
@Service
@Transactional(readOnly=true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final DoctorRepository doctorRepository;
    private final RoleRepository roleRepository;

    @Override
    public Users save(UserRegDto userRegDto){

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
    public void deleteUser(UserRegDto userRegDto) {
        Long id = userRegDto.getId();
        roleRepository.deleteRole(id);
        userRepository.deleteUser(id);
    }

    @Override
    public Optional<Users> getDocByid(Long id) {
        return userRepository.findById(id);
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
    public List<Users> getDoctors2() {
        return userRepository.findUsersByRole2("ROLE_DOCTOR");
    }
//    @Override
//    public List<UserRegDto> getDoctors2() {
//
//        //return userRepository.findUsersByRole2("ROLE_DOCTOR");
//        List <UserRegDto> users = userRepository.findAll().stream()
//                .map(user -> new UserRegDto(user)).filter(user -> user.getRoles().contains("ROLE_DOCTOR")).collect(Collectors.toList());
//        return users;
   // }


    @Override
    public Optional<Users> getDocById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void updateDoctor(UserRegDto userRegDto) {
        userRepository.updateDoc(userRegDto.getId(),userRegDto.getEmail(),userRegDto.getLocation(),userRegDto.getName());
    }


//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Users users = userRepository.findByEmail(email);
//
//        if(users == null) {
//            throw new UsernameNotFoundException("Invalid username or password.");
//        }
//        return new org.springframework.security.core.userdetails.User(users.getEmail(), users.getPassword(), mapRolesToAuthorities((Collection<Role>) users.getRoles()));
//    }
//
//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<com.example.bloodbank.appuser.Role> roles) {
//        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//    }
}
