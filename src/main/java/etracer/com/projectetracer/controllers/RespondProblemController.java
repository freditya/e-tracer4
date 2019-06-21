/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.controllers;

import etracer.com.projectetracer.entities.RespondProblem;
import etracer.com.projectetracer.repositories.EmployeeRepository;
import etracer.com.projectetracer.repositories.ReportProblemRepository;
import etracer.com.projectetracer.repositories.RespondProblemRepository;
import etracer.com.projectetracer.services.RespondProblemService;
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
public class RespondProblemController {
    @Autowired
    private RespondProblemRepository respondRepository;
    @Autowired
    private RespondProblemService respondService;
    @Autowired 
    private ReportProblemRepository reportRepository;
    @Autowired 
    private EmployeeRepository employeeRepository;
    
    @GetMapping("/respondproblem")
    public String respondproblem(Model model, RespondProblem respondproblem) {
        model.addAttribute("dataRespond", respondRepository.getAll());
        model.addAttribute("dataReport", reportRepository.getAll());
        model.addAttribute("dataEmployee", employeeRepository.getAll());
        return "trainer/respondproblem";
    }
    
    @PostMapping("/respondproblem/addData")
    public String addData(@Valid RespondProblem respondproblem) {
        respondRepository.save(respondproblem);
        return "redirect:/respondproblem";
    }
    @PostMapping("/respond/addData")
    public String addDataRespon(@Valid RespondProblem respondproblem) {
        respondRepository.save(respondproblem);
        return "redirect:/respondproblem";
    }
    @GetMapping("/respondproblem/update")
    public String update(@Valid RespondProblem respondproblem) {
        respondRepository.save(respondproblem);
        return "redirect:/respondproblem";
    }
    @GetMapping("/respond")
    public String respond(Model model, RespondProblem respondproblem) {
        model.addAttribute("dataRespond", respondRepository.getAll());
        model.addAttribute("dataReport", reportRepository.getAll());
        model.addAttribute("dataEmployee", employeeRepository.getAll());
        return "respond";
    }
}
