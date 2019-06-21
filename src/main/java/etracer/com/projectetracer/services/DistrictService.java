/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.services;

import etracer.com.projectetracer.entities.District;
import etracer.com.projectetracer.repositories.DistrictRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yosef
 */
@Service
    public class DistrictService {
    @Autowired
    private DistrictRepository districtRepository;
    
    public Iterable<District> findAllDistrict(){
        return districtRepository.findAll();
    }
    public List<District>getAll(){
        return districtRepository.getAll();
    }
}
