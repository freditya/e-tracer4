/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.controllers;

import etracer.com.projectetracer.entities.Assessment;
import etracer.com.projectetracer.entities.EvaluationParameter;
import etracer.com.projectetracer.repositories.EvaluationRepository;
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
public class EvaluationController {
    @Autowired
    private EvaluationRepository repository;
    
    @GetMapping("/eval_parameter")
    public String Evaluation(Model model) {
        model.addAttribute("dataEval", repository.getAll());
        return "admin/eval_parameter";
    }
    
    @PostMapping("/eval_parameter/addData")
    public String addData(@Valid EvaluationParameter evaluationParameter) {
        repository.save(evaluationParameter);
        return "redirect:/eval_parameter";
    }
    
    @GetMapping("/eval_parameter/update")
    public String updateData(@Valid EvaluationParameter evaluationParameter) {
        repository.save(evaluationParameter);
        return "redirect:/eval_parameter";
    }
}
