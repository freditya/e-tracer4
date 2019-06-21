/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.controllers;

import etracer.com.projectetracer.entities.Site;
import etracer.com.projectetracer.entities.UserRole;
import etracer.com.projectetracer.repositories.EmployeeRepository;
import etracer.com.projectetracer.repositories.SiteRepository;
import etracer.com.projectetracer.repositories.VillageRepository;
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
public class SiteController {
    
    @Autowired
    private SiteRepository siteRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private VillageRepository villageRepository;
    
    @GetMapping("/site")
    public String Site(Model model) {
        model.addAttribute("dataSite", siteRepository.getAll());
        model.addAttribute("dataEmployee", employeeRepository.findAll());
        model.addAttribute("dataVillage", villageRepository.findAll());
        return "admin/site";
    }
    @GetMapping("/site_trainer")
    public String site_trainer(Model model) {
        model.addAttribute("dataSite", siteRepository.getAll());
        model.addAttribute("dataEmployee", employeeRepository.findAll());
        model.addAttribute("dataVillage", villageRepository.findAll());
        return "trainer/site_trainer";
    }
    
    @PostMapping("/site/addData")
    public String addData(@Valid Site site) {
        siteRepository.save(site);
        return "redirect:/site";
    }
    @GetMapping("/site/update")
    public String update(@Valid Site site) {
        siteRepository.save(site);
        return "redirect:/site";
    }
}
