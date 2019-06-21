/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.repositories;

import etracer.com.projectetracer.entities.Assessment;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Relion31
 */
@Repository
public interface AssessmentRepository extends CrudRepository<Assessment, String> {

    @Query(
            value = "SELECT a.assessmentId, a.assessmentName, a.employeeId, a.isDelete \n"
            + "FROM assessment a\n"
            + "JOIN employee e ON a.employeeId=e.employeeId\n"
            + "WHERE a.isDelete='false'",
            nativeQuery = true)
    List<Assessment> getAll();
}
