/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.services;

import etracer.com.projectetracer.entities.ReportProblem;
import etracer.com.projectetracer.repositories.ReportProblemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yosef
 */
@Service
    public class ReportProblemService {
    @Autowired
    private ReportProblemRepository reportRepository;
    
    public Iterable<ReportProblem> findAllReportProblem(){
        return reportRepository.findAll();
    }
    public List<ReportProblem>getAll(){
        return reportRepository.getAll();
    }
}
