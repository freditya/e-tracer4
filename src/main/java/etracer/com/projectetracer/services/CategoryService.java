/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.services;

import etracer.com.projectetracer.entities.Category;
import etracer.com.projectetracer.entities.Employee;
import etracer.com.projectetracer.repositories.CategoryRepository;
import etracer.com.projectetracer.repositories.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author yosef
 */
    @Service
    public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public Iterable<Category> findAllCategory(){
        return categoryRepository.findAll();
    }
    public List<Category>getAll(){
        return categoryRepository.getAll();
    }
}
