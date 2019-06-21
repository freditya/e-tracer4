/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.services;

import etracer.com.projectetracer.entities.RespondProblem;
import etracer.com.projectetracer.repositories.RespondProblemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yosef
 */
@Service
    public class RespondProblemService {
    @Autowired
    private RespondProblemRepository respondRepository;
    
    public Iterable<RespondProblem> findAllRespondProblem(){
        return respondRepository.findAll();
    }
    public List<RespondProblem>getAll(){
        return respondRepository.getAll();
    }
}
