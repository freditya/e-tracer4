/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.controllers;

import etracer.com.projectetracer.entities.EvaluationParameter;
import etracer.com.projectetracer.entities.Score;
import etracer.com.projectetracer.repositories.EvaluationRepository;
import etracer.com.projectetracer.repositories.ScoreRepository;
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
public class ScoreController {
    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private EvaluationRepository evaluationRepository;
    
    @GetMapping("/score")
    public String Score(Model model) {
        model.addAttribute("dataScore", scoreRepository.getAll());
        model.addAttribute("dataEval", evaluationRepository.findAll());
        return "admin/score";
    }
    
    @PostMapping("/score/addData")
    public String addData(@Valid Score score) {
        scoreRepository.save(score);
        return "redirect:/score";
    }
    
    @GetMapping("/score/update")
    public String update(@Valid Score score) {
        scoreRepository.save(score);
        return "redirect:/score";
    }
}
