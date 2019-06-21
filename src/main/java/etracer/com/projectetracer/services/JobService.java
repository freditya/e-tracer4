/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.services;

import etracer.com.projectetracer.entities.Job;
import etracer.com.projectetracer.repositories.JobRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yosef
 */
@Service
    public class JobService {
    @Autowired
    private JobRepository jobRepository;
    
    public Iterable<Job> findAllJob(){
        return jobRepository.findAll();
    }
    public List<Job>getAll(){
        return jobRepository.getAll();
    }
}
