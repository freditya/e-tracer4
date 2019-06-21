/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.services;

import etracer.com.projectetracer.entities.SubDistrict;
import etracer.com.projectetracer.repositories.SubDistrictRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yosef
 */
@Service
    public class SubDistrictService {
    @Autowired
    private SubDistrictRepository subRepository;
    
    public Iterable<SubDistrict> findAllSubDistrict(){
        return subRepository.findAll();
    }
    public List<SubDistrict>getAll(){
        return subRepository.getAll();
    }
}
