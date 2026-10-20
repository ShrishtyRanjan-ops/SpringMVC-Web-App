
package com.example.springmvc;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final UserDAO userDAO = new UserDAO();

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam(name = "username", required = false) String username,
            @RequestParam(name = "password", required = false) String password,
            HttpSession session,
            Model model) {

        if (username == null || username.trim().isEmpty()
                || password == null || password.isEmpty()) {
            model.addAttribute("error",
                    "Please provide both username and password.");
            return "login";
        }

        User user = userDAO.findUser(username.trim());

        if (user == null) {
            model.addAttribute("error",
                    "No such user exists. Please register first.");
            return "login";
        }

        if (!userDAO.checkPassword(password, user.getPassword())) {
            model.addAttribute("error",
                    "The username and password combination is incorrect.");
            return "login";
        }

        session.setAttribute("loggedInUser", user.getUsername());
        return "redirect:/welcome";
    }
}
