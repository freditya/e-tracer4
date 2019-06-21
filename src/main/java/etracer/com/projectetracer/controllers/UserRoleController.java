/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.controllers;

import etracer.com.projectetracer.entities.Employee;
import etracer.com.projectetracer.entities.UserRole;
import etracer.com.projectetracer.repositories.EmployeeRepository;
import etracer.com.projectetracer.repositories.RoleRepository;
//import etracer.com.projectetracer.repositories.UserRepository;
import etracer.com.projectetracer.repositories.UserRoleRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Relion31
 */
@Controller
public class UserRoleController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private RoleRepository roleRepository;
    
    @GetMapping("/user_role")
    public String user_rolee(Model model) {
        model.addAttribute("datauserRole", userRoleRepository.getAll());
        model.addAttribute("dataRole", roleRepository.findAll());
        model.addAttribute("dataEmployee", employeeRepository.findAll());

        return "admin/user_role";
    }
    
    @PostMapping("/user_role/addData")
    public String addData(@Valid UserRole userRole) {
        userRoleRepository.save(userRole);
        return "redirect:/user_role";
    }
    
    @GetMapping("/user_role/update_role")
    public String updateRole(@Valid UserRole userRole) {
        userRoleRepository.save(userRole);
        return "redirect:/user_role";
    }
}
