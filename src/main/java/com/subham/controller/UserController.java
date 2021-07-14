package com.subham.controller;

import com.subham.dto.UserDto;
import com.subham.model.Role;
import com.subham.model.User;
import com.subham.repository.RoleRepository;
import com.subham.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    private UserRepository usersRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @GetMapping("/registrasi")
    public String registrationForm(UserDto userDto, Model model) {
        return "registration";
    }

    @PostMapping("/registrasi")
    public ModelAndView registerUser(@Valid UserDto userDto, BindingResult result) {
        ModelAndView view = new ModelAndView("registration");
        if (result.hasErrors()) {
            return view;
        }

        String email = userDto.getEmail();
        String firstname = userDto.getFirstname();
        String lastname = userDto.getLastname();
        String username = userDto.getUsername();
        String password = userDto.getPassword();

        if (usersRepository.findByUsername(username).isPresent()) {
            result.addError(new FieldError("userDto", "username", "Username has been used."));
            return view;
        }

        if (usersRepository.findByEmail(email).isPresent()) {
            result.addError(new FieldError("userDto", "email", "Email has been used."));
            return view;
        }
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findById(2l).get());
        User user = new User();
        user.setEmail(email);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        user.setRoles(roles);
        usersRepository.save(user);

        return new ModelAndView("success");
    }

    @GetMapping("/admin")
    public String showUsers(Model model) {
        model.addAttribute("users", usersRepository.findAll());
        return "admin";
    }
}
