/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.services;

import etracer.com.projectetracer.entities.Village;
import etracer.com.projectetracer.repositories.VillageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yosef
 */
@Service
    public class VillageService {
    @Autowired
    private VillageRepository villageRepository;
    
    public Iterable<Village> findAllSubDistrict(){
        return villageRepository.findAll();
    }
    public List<Village>getAll(){
        return villageRepository.getAll();
    }
}
