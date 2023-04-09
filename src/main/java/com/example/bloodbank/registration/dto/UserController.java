package com.example.bloodbank.registration.dto;

import com.example.bloodbank.appuser.Users;
import com.example.bloodbank.appuser.dao.UserRepository;
import com.example.bloodbank.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@AllArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserRegDto user)
    {
        Users user1 = userRepository.findByEmail(user.getEmail());
        System.out.println("Am intrat in metoda asta");
        if(user1.getPassword().equals(user.getPassword())) {
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
}
