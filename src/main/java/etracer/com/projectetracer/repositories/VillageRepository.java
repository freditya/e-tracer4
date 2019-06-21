/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.repositories;

import etracer.com.projectetracer.entities.Village;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Relion31
 */
@Repository
public interface VillageRepository extends CrudRepository<Village, String>{
//     @Query(
//            value = "SELECT * FROM village v\n"
//            + "WHERE v.isDelete='false'",
//            nativeQuery = true)
     @Query(
            value = "SELECT v.villageId, v.villageName, v.subDistrictId, sub.subDistrictName, v.isDelete \n"
            + "FROM village v\n"
            + "JOIN sub_district sub ON v.subDistrictId = sub.subDistrictId\n"
            + "WHERE v.isDelete='false'",
            nativeQuery = true)
    List<Village> getAll();
}
