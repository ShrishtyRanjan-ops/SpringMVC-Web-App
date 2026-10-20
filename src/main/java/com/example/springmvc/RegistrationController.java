
package com.example.springmvc;

import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    private final UserDAO userDAO = new UserDAO();

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(
            @RequestParam(name = "username", required = false) String username,
            @RequestParam(name = "password", required = false) String password,
            @RequestParam(name = "employeeNumber", required = false) String employeeNumber,
            @RequestParam(name = "email", required = false) String email,
            Model model) {

        // Check that all fields are filled
        if (isBlank(username) || isBlank(password)
                || isBlank(employeeNumber) || isBlank(email)) {
            model.addAttribute("error", "All fields are mandatory.");
            return "register";
        }

        username = username.trim();
        employeeNumber = employeeNumber.trim();
        email = email.trim();

        // Password must be exactly 6 characters
        if (password.length() != 6) {
            model.addAttribute("error",
                    "Password must be exactly 6 characters long.");
            return "register";
        }

        // One alphabet followed by exactly 4 digits
        if (!Pattern.matches("[A-Za-z][0-9]{4}", employeeNumber)) {
            model.addAttribute("error",
                    "Employee number must have one alphabet followed by exactly 4 digits, e.g. A1234.");
            return "register";
        }

        // Check for an existing username
        try {
            if (userDAO.findUser(username) != null) {
                model.addAttribute("error",
                        "Username already exists. Please choose another username.");
                return "register";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            model.addAttribute("error",
                    "Unable to verify username. Please try again.");
            return "register";
        }

        // Create user
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmployeeNumber(employeeNumber);
        user.setEmail(email);

        boolean registered = userDAO.registerUser(user);

        if (registered) {
            model.addAttribute("success",
                    "Registration successful! Please log in.");
            return "login";
        }

        model.addAttribute("error",
                "Registration failed. Please check whether the username or employee number is already registered, and try again.");
        return "register";
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
