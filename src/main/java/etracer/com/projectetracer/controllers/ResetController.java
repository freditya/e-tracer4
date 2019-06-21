/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Relion31
 */

@Controller
public class ResetController {
     @GetMapping("/resetPassword")
    public String reset() {
        return "resetPassword";
    }
}
