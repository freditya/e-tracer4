/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.repositories;

import etracer.com.projectetracer.entities.SubDistrict;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yosef
 */
@Repository
public interface SubDistrictRepository extends CrudRepository<SubDistrict, String> {
    @Query(
            value = "SELECT sub.subDistrictId, sub.subDistrictName, sub.districtId, sub.isDelete \n"
            + "FROM sub_district sub\n"
            + "JOIN district d ON sub.districtId = d.districtId\n"
            + "WHERE sub.isDelete='false'",
            nativeQuery = true)
    List<SubDistrict> getAll();
}
