/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.controllers;

import etracer.com.projectetracer.entities.ConfirmationToken;
import etracer.com.projectetracer.entities.Employee;
import etracer.com.projectetracer.repositories.DepartmentRepository;
import etracer.com.projectetracer.repositories.EmployeeRepository;
import etracer.com.projectetracer.repositories.JobRepository;
import etracer.com.projectetracer.repositories.TokenRepository;
import etracer.com.projectetracer.services.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Relion31
 */
@Controller
public class UserAccountController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private TokenRepository confirmationTokenRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @RequestMapping(value = "/formregistrasi", method = RequestMethod.GET)
    public ModelAndView displayRegistration(ModelAndView modelAndView, Employee employee, Model model) {
        modelAndView.addObject("employee", employee);
        model.addAttribute("dataEmployee", employeeRepository.getAll());
        model.addAttribute("dataJob", jobRepository.findAll());
        model.addAttribute("dataDepartment", departmentRepository.findAll());
        modelAndView.setViewName("addUser");
        return modelAndView;
    }

    @RequestMapping(value = "/formregistrasi", method = RequestMethod.POST)
    public ModelAndView registerUser(ModelAndView modelAndView, Employee employee, String password) {

        Employee existingUser = employeeRepository.findByEmail(employee.getEmail());
        if (existingUser != null) {
            modelAndView.addObject("message", "This email already exists!");
            modelAndView.setViewName("error");
        } else {
//            employee.setEmployeeId("0");
            employee.setIsDelete("true");
            employee.setPassword(bCryptPasswordEncoder.encode(password));
            employeeRepository.save(employee);

            ConfirmationToken token = new ConfirmationToken(employee);

            confirmationTokenRepository.save(token);

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(employee.getEmail());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("upnormal.bootcamp@gmail.com");
            mailMessage.setText("To confirm your account, please click here : "
                    + "http://localhost:8083/confirm-account?token=" + token.getToken());
            emailSenderService.sendEmail(mailMessage);
            modelAndView.addObject("email", employee.getEmail());
            modelAndView.setViewName("success");
        }

        return modelAndView;
    }

    @RequestMapping(value = "/confirm-account", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token") String token) {
        ConfirmationToken token1 = confirmationTokenRepository.findByToken(token);

        if (token != null) {
            Employee employee = employeeRepository.findByEmail(token1.getEmployeeId().getEmail());
            employee.setIsDelete("false");
            modelAndView.addObject("employee", employee);
            modelAndView.addObject("email", employee.getEmail());
            employeeRepository.save(employee);
            modelAndView.setViewName("resetPassword");
        } else {
            modelAndView.addObject("message", "The link is invalid or broken!");
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }

//      Endpoint to update a user's password
    @RequestMapping(value = "/reset-password", method = RequestMethod.POST)
    public ModelAndView resetUserPassword(ModelAndView modelAndView, Employee employee, String password, String rytapepassword) {
        if (password.equals(rytapepassword)) {
            if (employee.getEmail() != null) {
                // Use email to find user
                Employee token = employeeRepository.findByEmail(employee.getEmail());
                token.setPassword(bCryptPasswordEncoder.encode(password));
                employeeRepository.save(token);
                modelAndView.addObject("message", "Password successfully reset. You can now log in with the new credentials.");
                modelAndView.setViewName("suksesReset");
            } else {
                modelAndView.addObject("message", "The link is invalid or broken!");
                modelAndView.setViewName("error");
            }
        } else {
            modelAndView.addObject("message", "password is note same");
            modelAndView.setViewName("verrified");
        }

        return modelAndView;
    }
//    @RequestMapping(value = "/reset-password", method = RequestMethod.POST)
//    public String resetUserPassword(Model model, Employee employee, String password, String rytapepassword) {
//        String result = "redirect:/reset-password/reset?error";
//        String email = "";
//        String error = "";
//        if (password.equals(rytapepassword)) {
//            if (employee.getEmail() != null) {
//                // Use email to find user
//                Employee token = employeeRepository.findByEmail(employee.getEmail());
//                token.setPassword(bCryptPasswordEncoder.encode(password));
//                employeeRepository.save(token);
////                modelAndView.addObject("message", "Password successfully reset. You can now log in with the new credentials.");
////                modelAndView.setViewName("suksesReset");
//                result = "reset-password/success=reset";
//            } else {
////                modelAndView.addObject("message", "The link is invalid or broken!");
////                modelAndView.setViewName("error");
//                error = "different";
//                result = "redirect:/reset-password/reset?error=" + error;
//            }
//        } else {
////            modelAndView.addObject("message", "password is note same");
////            modelAndView.setViewName("verrified");
//            error = "different";
//                result = "redirect:/reset-password/reset?error=" + error;
//        }
//
////        return modelAndView;
//        return result;
//    }

    // Display the form
    @RequestMapping(value = "/forgot-password", method = RequestMethod.GET)
    public ModelAndView displayResetPassword(ModelAndView modelAndView, Employee employee) {
        modelAndView.addObject("employee", employee);
        modelAndView.setViewName("forgotPassword");
        return modelAndView;
    }

    // Receive the address and send an email
    @RequestMapping(value = "/forgot-password", method = RequestMethod.POST)
    public ModelAndView forgotUserPassword(ModelAndView modelAndView, Employee employee) {
        Employee existingUser = employeeRepository.findByEmail(employee.getEmail());
        if (existingUser != null) {
            // Create token
            ConfirmationToken confirmationToken = new ConfirmationToken(existingUser);

            // Save it
            confirmationTokenRepository.save(confirmationToken);

            // Create the email
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(existingUser.getEmail());
            mailMessage.setSubject("Complete Forgot Password!");
            mailMessage.setFrom("upnormal.bootcamp@gmail.com");
            mailMessage.setText("To complete the password reset process, please click here: "
                    + "http://localhost:8083/confirm-reset?token=" + confirmationToken.getToken());

            // Send the email
            emailSenderService.sendEmail(mailMessage);

            modelAndView.addObject("email", employee.getEmail());
            modelAndView.setViewName("success");

        } else {
            modelAndView.addObject("message", "This email address does not exist!");
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }

    // Endpoint to confirm the token
    @RequestMapping(value = "/confirm-reset", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView validateResetToken(ModelAndView modelAndView, @RequestParam("token") String token) {
        ConfirmationToken token1 = confirmationTokenRepository.findByToken(token);

        if (token != null) {
            Employee employee = employeeRepository.findByEmail(token1.getEmployeeId().getEmail());
            employee.setIsDelete("false");
            employeeRepository.save(employee);
            modelAndView.addObject("employee", employee);
            modelAndView.addObject("email", employee.getEmail());
            modelAndView.setViewName("resetPassword");
        } else {
            modelAndView.addObject("message", "The link is invalid or broken!");
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public TokenRepository getTokenRepository() {
        return confirmationTokenRepository;
    }

    public void setTokenRepository(TokenRepository confirmationTokenRepository) {
        this.confirmationTokenRepository = confirmationTokenRepository;
    }

    public EmailSenderService getEmailSenderService() {
        return emailSenderService;
    }

    public void setEmailSenderService(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }
}
