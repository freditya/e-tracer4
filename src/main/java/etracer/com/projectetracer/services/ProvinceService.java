/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.services;

import etracer.com.projectetracer.entities.Province;
import etracer.com.projectetracer.repositories.ProvinceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Relion31
 */
@Service
public class ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;
    
    public Iterable<Province> findAllProvince(){
        return provinceRepository.findAll();
    }
    public List<Province>getAll(){
        return provinceRepository.getAll();
    }
}
