
package com.example.springmvc;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ProfileController {

    private final UserDAO userDAO = new UserDAO();

    @GetMapping("/profile")
    public String showProfile(HttpSession session, Model model) {

        String username = (String) session.getAttribute("loggedInUser");

        if (username == null) {
            return "redirect:/login";
        }

        User user = userDAO.findUser(username);

        if (user == null) {
            session.invalidate();
            return "redirect:/login";
        }

        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping("/profile")
    public String updateProfile(
            @ModelAttribute("user") User user,
            HttpSession session,
            Model model) {

        String username = (String) session.getAttribute("loggedInUser");

        if (username == null) {
            return "redirect:/login";
        }

        boolean updated = userDAO.updateProfile(username, user);

        if (updated) {
            return "redirect:/profile?success";
        }

        model.addAttribute("error", "Profile update nahi ho payi.");
        model.addAttribute("user", user);
        return "profile";
    }
}
