
package com.example.springmvc;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeDAO employeeDAO = new EmployeeDAO();

    private boolean isLoggedIn(HttpSession session) {
        return session.getAttribute("loggedInUser") != null;
    }

    @GetMapping
    public String listEmployees(HttpSession session, Model model) {
        if (!isLoggedIn(session)) {
            return "redirect:/login";
        }

        model.addAttribute("employees", employeeDAO.getAllEmployees());
        model.addAttribute("searched", false);
        return "employees";
    }

    @GetMapping("/add")
    public String showAddForm(HttpSession session) {
        if (!isLoggedIn(session)) {
            return "redirect:/login";
        }
        return "addEmployee";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee,
                              HttpSession session, Model model) {
        if (!isLoggedIn(session)) {
            return "redirect:/login";
        }

        if (employeeDAO.addEmployee(employee)) {
            return "redirect:/employees";
        }

        model.addAttribute("error", "Employee add nahi ho paya.");
        return "addEmployee";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id,
                               HttpSession session, Model model) {
        if (!isLoggedIn(session)) {
            return "redirect:/login";
        }

        Employee employee = employeeDAO.getEmployeeById(id);
        if (employee == null) {
            return "redirect:/employees";
        }

        model.addAttribute("employee", employee);
        return "editEmployee";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute Employee employee,
                                 HttpSession session) {
        if (!isLoggedIn(session)) {
            return "redirect:/login";
        }

        boolean updated = employeeDAO.updateEmployee(employee);
        return updated
                ? "redirect:/employees"
                : "redirect:/employees?error=update";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteConfirmation(@PathVariable("id") int id,
                                         HttpSession session, Model model) {
        if (!isLoggedIn(session)) {
            return "redirect:/login";
        }

        Employee employee = employeeDAO.getEmployeeById(id);
        if (employee == null) {
            return "redirect:/employees";
        }

        model.addAttribute("employee", employee);
        return "deleteEmployee";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id,
                                 HttpSession session) {
        if (!isLoggedIn(session)) {
            return "redirect:/login";
        }

        boolean deleted = employeeDAO.deleteEmployee(id);
        return deleted
                ? "redirect:/employees"
                : "redirect:/employees?error=delete";
    }

    @GetMapping("/search")
    public String searchEmployee(
            @RequestParam(name = "id", required = false) Integer id,
            HttpSession session, Model model) {

        if (!isLoggedIn(session)) {
            return "redirect:/login";
        }

        if (id == null) {
            return "redirect:/employees";
        }

        Employee employee = employeeDAO.getEmployeeById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("searched", true);

        if (employee == null) {
            model.addAttribute("error", "Is ID ka employee nahi mila.");
        }

        return "employees";
    }
}
