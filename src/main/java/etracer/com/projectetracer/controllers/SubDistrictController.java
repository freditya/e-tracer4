/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.controllers;

import etracer.com.projectetracer.entities.SubDistrict;
import etracer.com.projectetracer.repositories.DistrictRepository;
import etracer.com.projectetracer.repositories.SubDistrictRepository;
import etracer.com.projectetracer.services.SubDistrictService;
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
public class SubDistrictController {
  @Autowired
    private SubDistrictRepository subRepository;
    @Autowired
    private SubDistrictService subService;
    @Autowired 
    private DistrictRepository districtRepository;
    
    @GetMapping("/subdistrict")
    public String subdistrict(Model model, SubDistrict subdistrict) {
        model.addAttribute("dataSubDistrict", subRepository.getAll());
        model.addAttribute("dataDistrict", districtRepository.getAll());
        return "admin/subdistrict";
    }
    
    @PostMapping("/subdistrict/addData")
    public String addData(@Valid SubDistrict subdistrict) {
        subRepository.save(subdistrict);
        return "redirect:/subdistrict";
    }
    @GetMapping("/subdistrict/update")
    public String update(@Valid SubDistrict subdistrict) {
        subRepository.save(subdistrict);
        return "redirect:/subdistrict";
    }  
}
