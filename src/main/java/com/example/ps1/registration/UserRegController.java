package com.example.ps1.registration;

import com.example.ps1.appuser.Users;
import com.example.ps1.appuser.dao.UserRepository;
import com.example.ps1.registration.dto.UserRegDto;
import com.example.ps1.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

//@RestController
@Controller
@RequestMapping()
@AllArgsConstructor
public class UserRegController {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        UserRegDto user = new UserRegDto();
        model.addAttribute("user", user);
        return "register";
    }

    @RequestMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping("/admin")
    public ModelAndView userDashboard() {
        return new ModelAndView("admin");
    }

    @RequestMapping("/doctor")
    public ModelAndView adminDashboard() {
        return new ModelAndView("doctor");
    }

    @RequestMapping("/donator")
    public ModelAndView donatorDashboard() {
        return new ModelAndView("donator");
    }

    @PostMapping("/register/save")
    public String registration(@ModelAttribute("user") UserRegDto userDto,
                               BindingResult result,
                               Model model) {
        Users existingUser = userService.getUser(userDto.getEmail());

        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "/register";
        }

        userService.save(userDto);
        return "redirect:/register?success";
    }
    @GetMapping("/users")
    public String doctors(Model model)
    {
        List<Users> doctors = userService.getDoctors();
        model.addAttribute("users", doctors);
        return "users";

    }
    @PostMapping("/adduser")
    public String addUser(UserRegDto userRegDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }

        userService.saveDoc(userRegDto);
        return "redirect:/admin";
    }
    @GetMapping("/edit/{email}")
    public String showUpdateForm(@PathVariable("email") String email, Model model) {
        Users user = userService.getUser(email);
        if(user == null)
            throw new UsernameNotFoundException("Aoleo");
        model.addAttribute("user", user);
        return "update-user";
    }
    @PostMapping("/update/{email}")
    public String updateUser(@PathVariable("email") String email, UserRegDto user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setEmail(email);
            return "update-user";
        }

        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{email}")
    public String deleteUser(@PathVariable("email") String email, Model model) {
        Users user = userService.getUser(email);
        if(user == null)
            throw new UsernameNotFoundException("Aoleo nu putem sterge");
        userService.delete(email);
        return "redirect:/admin";
    }

}
