/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.repositories;

import etracer.com.projectetracer.entities.Employee;
import etracer.com.projectetracer.entities.Score;
import etracer.com.projectetracer.entities.Site;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Relion31
 */
@Repository
public interface SiteRepository extends CrudRepository<Site, String> {

    @Query(
            value = "SELECT * FROM site s WHERE s.isDelete='false'",
            nativeQuery = true)
    List<Site> getAll();
     @Query(
            value = "SELECT COUNT(site.siteId) as total FROM site",
            nativeQuery = true)
    List<Site> getCount();
//    @Query(
//            value = "SELECT s.siteId, s.siteName, s.villageId, s.employeeId, s.isDelete \n"
//            + "FROM site s\n"
//            + "JOIN village v ON s.villageId=v.villageId\n"
//            + "JOIN employee e ON s.employeeId=e.employeeId\n"
//            + "WHERE s.isDelete='false'",
//            nativeQuery = true)
//    List<Site> getAll();
}
