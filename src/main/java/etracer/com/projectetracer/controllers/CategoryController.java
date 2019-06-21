/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.controllers;

import etracer.com.projectetracer.entities.Assessment;
import etracer.com.projectetracer.entities.Category;
import etracer.com.projectetracer.entities.Employee;
import etracer.com.projectetracer.repositories.AssessmentRepository;
import etracer.com.projectetracer.repositories.CategoryRepository;
import etracer.com.projectetracer.repositories.EmployeeRepository;
import etracer.com.projectetracer.repositories.EvaluationRepository;
import etracer.com.projectetracer.services.CategoryService;
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
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryService categoryService;
    @Autowired 
    private EmployeeRepository employeeRepository;
    @Autowired 
    private AssessmentRepository assessmentRepository;
    @Autowired 
    private EvaluationRepository evaluationRepository;
    
    @GetMapping("/category")
    public String employee(Model model, Category category ) {
        model.addAttribute("dataCategory", categoryRepository.getAll());
        model.addAttribute("dataEmployee", employeeRepository.getAll());
        model.addAttribute("dataAssessment", assessmentRepository.getAll());
        model.addAttribute("dataEvaluation", evaluationRepository.getAll());
        return "admin/category";
    }
    
    @PostMapping("/category/addData")
    public String addData(@Valid Category category) {
        categoryRepository.save(category);
        return "redirect:/category";
    }
    @GetMapping("/category/update")
    public String delete(@Valid Category category) {
        categoryRepository.save(category);
        return "redirect:/category";
    }
}
