/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.repositories;

import etracer.com.projectetracer.entities.Province;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Relion31
 */
@Repository
public interface ProvinceRepository extends CrudRepository<Province, String>{
    @Query(
  value = "SELECT * FROM province u WHERE u.is_delete =\'false\'", 
  nativeQuery = true)
     List<Province> getAll();
}
