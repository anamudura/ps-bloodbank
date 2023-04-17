package com.example.bloodbank.registration.dto;

import com.example.bloodbank.appuser.Users;
import com.example.bloodbank.appuser.dao.RoleRepository;
import com.example.bloodbank.appuser.dao.UserRepository;
import com.example.bloodbank.service.UserService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@AllArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;
    private final RoleRepository roleRepository;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserRegDto user) {
        Users user1 = userRepository.findByEmail(user.getEmail());
        System.out.println("Am intrat in metoda asta");
        if (user1.getPassword().equals(user.getPassword())) {
            System.out.println("LOGIN SUCCESSFUL");
            return ResponseEntity.ok(user1);
        }
        return (ResponseEntity<?>) ResponseEntity.internalServerError();

    }

    @PostMapping("/register")
    public ResponseEntity<?> registration(@RequestBody UserRegDto userDto,
                                          BindingResult result) {
        Users existingUser = userService.getUser(userDto.getEmail());

        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
            return (ResponseEntity<?>) ResponseEntity.internalServerError();
        }

        userService.save(userDto);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/users")
    public ResponseEntity<List<Users> >doctors() {
         List<Users> doctors = userService.getDoctors2();
        return ResponseEntity.ok().body(userService.getDoctors2());

    }
    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {

        roleRepository.deleteRole(id);
        userRepository.deleteUser(id);
        return ResponseEntity.ok("");
    }


}
