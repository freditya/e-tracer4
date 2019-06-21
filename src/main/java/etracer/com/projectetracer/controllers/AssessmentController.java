/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.controllers;

import etracer.com.projectetracer.entities.Assessment;
import etracer.com.projectetracer.repositories.AssessmentRepository;
import etracer.com.projectetracer.repositories.EmployeeRepository;
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
public class AssessmentController {
    @Autowired
    private AssessmentRepository assessmentRepository;
    @Autowired 
    private EmployeeRepository employeeRepository;
    
    @GetMapping("/assessment")
    public String employee(Model model) {
        model.addAttribute("dataAssessment", assessmentRepository.getAll());
        model.addAttribute("dataEmployee", employeeRepository.getAll());
        return "admin/assessment";
    }
    
    @PostMapping("/assessment/addData")
    public String addData(@Valid Assessment assessment) {
        assessmentRepository.save(assessment);
        return "redirect:/assessment";
    }
    @GetMapping("/assessment/update")
    public String update(@Valid Assessment assessment) {
        assessmentRepository.save(assessment);
        return "redirect:/assessment";
    }
}
