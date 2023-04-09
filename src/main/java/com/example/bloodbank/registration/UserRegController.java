//package com.example.bloodbank.registration;
//
//import com.example.bloodbank.appuser.Users;
//import com.example.bloodbank.appuser.dao.UserRepository;
//import com.example.bloodbank.registration.dto.UserRegDto;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//
//@RestController
//@AllArgsConstructor
////@CrossOrigin(origins = "http://localhost:4200")
//public class UserRegController {
//
//
////    private final UserService userService;
//    @Autowired
//    private final UserRepository userRepository;
//
//    // http://localhost:8080/login
//    @PostMapping("/login")
//    public ResponseEntity<?> loginUser(@RequestBody UserRegDto user)
//    {
//       Users user1 = userRepository.findByEmail(user.getEmail());
//        System.out.println("Am intrat in metoda asta");
//       if(user1.getPassword().equals(user.getPassword()))
//           return ResponseEntity.ok(user1);
//        return (ResponseEntity<?>) ResponseEntity.internalServerError();
//
//    }
//
////    @GetMapping("/register")
////    public String showRegistrationForm(Model model) {
////        UserRegDto user = new UserRegDto();
////        model.addAttribute("user", user);
////        return "register";
////    }
////
////    @RequestMapping("")
////    public ModelAndView login() {
////        return new ModelAndView("login");
////    }
////
////    @RequestMapping("/admin")
////    public ModelAndView userDashboard() {
////        return new ModelAndView("admin");
////    }
////
////    @RequestMapping("/doctor")
////    public ModelAndView adminDashboard() {
////        return new ModelAndView("doctor");
////    }
////
////    @RequestMapping("/donator")
////    public ModelAndView donatorDashboard() {
////        return new ModelAndView("donator");
////    }
////
////    @PostMapping("/register/save")
////    public String registration(@ModelAttribute("user") UserRegDto userDto,
////                               BindingResult result,
////                               Model model) {
////        Users existingUser = userService.getUser(userDto.getEmail());
////
////        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
////            result.rejectValue("email", null,
////                    "There is already an account registered with the same email");
////        }
////
////        if (result.hasErrors()) {
////            model.addAttribute("user", userDto);
////            return "/register";
////        }
////
////        userService.save(userDto);
////        return "redirect:/register?success";
////    }
////
////    @GetMapping("/users")
////    public String doctors(Model model) {
////        // List<Users> doctors = userService.getDoctors();
////        List<Users> doctors = userService.getDoctors2();
////        model.addAttribute("users", doctors);
////        return "users";
////
////    }
////
////    @PostMapping("/adduser")
////    public String addUser(UserRegDto userRegDto, BindingResult result, Model model) {
////        if (result.hasErrors()) {
////            return "add-user";
////        }
////
////        userService.saveDoc(userRegDto);
////        return "redirect:/admin";
////    }
////
////    @GetMapping("/edit/{email}")
////    public String showUpdateForm(@PathVariable("email") String email, Model model) {
////        Users user = userService.getUser(email);
////        if (user == null)
////            throw new UsernameNotFoundException("Aoleo");
////        model.addAttribute("user", user);
////        return "update-user";
////    }
////
////    @GetMapping("/delete-edit/{email}")
////    public String showUpdateFormDel(@PathVariable("email") String email, Model model) {
////        Users user = userService.getUser(email);
////        if (user == null)
////            throw new UsernameNotFoundException("Aoleo");
////        model.addAttribute("user", user);
////        return "delete-user";
////    }
////
////    @PostMapping("/update/{id}")
////    public String updateUser(@PathVariable("id") Long id, UserRegDto user,
////                             BindingResult result, Model model) {
////        if (result.hasErrors()) {
////            user.setId(id);
////            return "update-user";
////        }
////
////        //userService.saveDoc(user);
////        userService.updateDoctor(user);
////        return "redirect:/admin";
////    }
////
////    @PostMapping("/delete/{id}")
////    public String deleteUser(@PathVariable("id") Long id, UserRegDto user, BindingResult result,
////                             Model model) {
////        if (result.hasErrors()) {
////            user.setId(id);
////            return "delete-user";
////        }
////        userService.deleteUser(user);
////        return "redirect:/admin";
////    }
//
//}
