/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.repositories;

import etracer.com.projectetracer.entities.District;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yosef
 */
@Repository
public interface DistrictRepository extends CrudRepository<District, String> {
//    @Query(
//            value = "SELECT * FROM district d WHERE d.isDelete='false'",
//            nativeQuery = true)
    @Query(
            value = "SELECT di.districtId, di.districtName, di.province_id, di.isDelete \n"
            + "FROM district di\n"
            + "JOIN province p ON di.province_id = p.province_id\n"
            + "WHERE di.isDelete='false'",
            nativeQuery = true)
    List<District> getAll();
}
