/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.controllers;

import etracer.com.projectetracer.entities.District;
import etracer.com.projectetracer.repositories.DistrictRepository;
import etracer.com.projectetracer.repositories.ProvinceRepository;
import etracer.com.projectetracer.services.DistrictService;
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
public class DistrictController {
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private DistrictService districtService;
    @Autowired 
    private ProvinceRepository provinceRepository;
    
    
    @GetMapping("/district")
    public String district(Model model, District district) {
        model.addAttribute("dataDistrict", districtRepository.getAll());
        model.addAttribute("dataProvince", provinceRepository.findAll());
        return "admin/district";
    }
    
    @PostMapping("/district/addData")
    public String addData(@Valid District district) {
        districtRepository.save(district);
        return "redirect:/district";
    }
    @GetMapping("/district/update")
    public String update(@Valid District district) {
        districtRepository.save(district);
        return "redirect:/district";
    }
}

