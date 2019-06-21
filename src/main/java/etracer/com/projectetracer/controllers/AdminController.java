/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.controllers;

import etracer.com.projectetracer.repositories.EmployeeRepository;
import etracer.com.projectetracer.repositories.SiteRepository;
import etracer.com.projectetracer.repositories.countRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Relion31
 */
@Controller
public class AdminController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private countRepository r;
    
    @RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
    public String index(Model model){
//        model.addAttribute("dataSite", siteRepository.getCount());
//        model.addAttribute("dataEmployee", r.getCount());
        return "admin/dashboard";
    }
}
