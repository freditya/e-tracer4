/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.controllers;

import etracer.com.projectetracer.entities.Employee;
import etracer.com.projectetracer.entities.Province;
import etracer.com.projectetracer.repositories.DepartmentRepository;
import etracer.com.projectetracer.repositories.EmployeeRepository;
import etracer.com.projectetracer.repositories.JobRepository;
import etracer.com.projectetracer.repositories.ProvinceRepository;
import etracer.com.projectetracer.services.EmployeeService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Relion31
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private JobRepository jobRepository;

    @GetMapping("/employee")
    public String employee(Model model, Employee employee) {
        model.addAttribute("dataEmployee", employeeRepository.getAll());
        model.addAttribute("dataDepartment", departmentRepository.findAll());
        model.addAttribute("dataJob", jobRepository.findAll());
        model.addAttribute("geder", employee.getGender());
        return "admin/employee";
    }

    @PostMapping("/employee/addData")
    public String addData(@Valid Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employee";
    }

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), true);
//        binder.registerCustomEditor(Date.class, editor);
//    }
    
    @GetMapping("/employee/update")
    public String updateEmployee(@Valid Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employee";
    }

    @RequestMapping(value={"/employee_Bootcamp"}, method = RequestMethod.GET)
    public String users(Model model, HttpServletRequest httpServletRequest) {
//      untuk get data pribadi dari user login
        model.addAttribute("dataUser", employeeRepository.getByUsername(httpServletRequest.getRemoteUser()));
        model.addAttribute("dataEmployee", employeeRepository.getAll());
        model.addAttribute("dataDepartment", departmentRepository.findAll());
        model.addAttribute("dataJob", jobRepository.findAll());
        model.addAttribute("geder", employeeRepository.getAll());
        
        return "employee_bootcamp";
    }
    @RequestMapping(value={"/emp"}, method = RequestMethod.GET)
    public String trainer(Model model, Employee employee) {
//      untuk get data pribadi dari user login
        model.addAttribute("dataEmployee", employeeRepository.getAll());
        model.addAttribute("dataDepartment", departmentRepository.findAll());
        model.addAttribute("dataJob", jobRepository.findAll());
        model.addAttribute("geder", employee.getGender());
        return "trainer/emp";
    }
//    @RequestMapping(value = "/employee/addData", method = RequestMethod.POST)
//    public String saveForm(@ModelAttribute("registerCommand") @Valid Employee employee, BindingResult bindingResult, Model model){
//
//        if(bindingResult.hasErrors()) {
//
//            return "redirect:/employee";
//        }
//        else {
//        employeeRepository.save(employee);
//        return "register-success";
//        }
//    }
}
