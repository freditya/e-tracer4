/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.controllers;

import etracer.com.projectetracer.entities.Job;
import etracer.com.projectetracer.repositories.JobRepository;
import etracer.com.projectetracer.services.JobService;
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
public class JobController {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private JobService jobService;
    
    @GetMapping("/job")
    public String job(Model model, Job job) {
        model.addAttribute("dataJob", jobRepository.getAll());
        return "admin/job";
    }
    
    @PostMapping("/job/addData")
    public String addData(@Valid Job job) {
        jobRepository.save(job);
        return "redirect:/job";
    }
    @GetMapping("/job/update")
    public String update(@Valid Job job) {
        jobRepository.save(job);
        return "redirect:/job";
    }
}

