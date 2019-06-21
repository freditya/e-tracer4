/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.controllers;

import etracer.com.projectetracer.entities.Assessment;
import etracer.com.projectetracer.entities.Category;
import etracer.com.projectetracer.entities.Department;
import etracer.com.projectetracer.entities.Employee;
import etracer.com.projectetracer.repositories.AssessmentRepository;
import etracer.com.projectetracer.repositories.CategoryRepository;
import etracer.com.projectetracer.repositories.DepartmentRepository;
import etracer.com.projectetracer.repositories.EmployeeRepository;
import etracer.com.projectetracer.repositories.EvaluationRepository;
import etracer.com.projectetracer.repositories.VillageRepository;
import etracer.com.projectetracer.services.CategoryService;
import etracer.com.projectetracer.services.DepartmentService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
/**
 *
 * @author yosef
 */
@Controller
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private DepartmentService departmentService;
    @Autowired 
    private VillageRepository villageRepository;
    @Autowired 
    private EmployeeRepository employeeRepository;
    
    @GetMapping("/department")
    public String department(Model model) {
        model.addAttribute("dataDepartment", departmentRepository.getAll());
        model.addAttribute("dataVillage", villageRepository.getAll());
        model.addAttribute("dataEmployee", employeeRepository.getAll());
        return "admin/department";
    }
    
    @PostMapping("/department/addData")
    public String addData(@Valid Department department) {
        departmentRepository.save(department);
        return "redirect:/department";
    }
    @GetMapping("/department/update")
    public String update(@Valid Department department) {
        departmentRepository.save(department);
        return "redirect:/department";
    }
}
