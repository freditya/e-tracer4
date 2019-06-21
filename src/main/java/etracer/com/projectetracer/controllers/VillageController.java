/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.controllers;

import etracer.com.projectetracer.entities.Village;
import etracer.com.projectetracer.repositories.SubDistrictRepository;
import etracer.com.projectetracer.repositories.VillageRepository;
import etracer.com.projectetracer.services.VillageService;
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
public class VillageController {
    @Autowired
    private VillageRepository villageRepository;
    @Autowired
    private VillageService villageService;
    @Autowired 
    private SubDistrictRepository subdistrictRepository;
    
    @GetMapping("/village")
    public String village(Model model) {
        model.addAttribute("dataVillage", villageRepository.getAll());
        model.addAttribute("dataSubDistrict", subdistrictRepository.findAll());
        return "admin/village";
    }
    
    @PostMapping("/village/addData")
    public String addData(@Valid Village village) {
        villageRepository.save(village);
        return "redirect:/village";
    }
    @GetMapping("/village/update")
    public String update(@Valid Village village) {
        villageRepository.save(village);
        return "redirect:/village";
    }  
}
