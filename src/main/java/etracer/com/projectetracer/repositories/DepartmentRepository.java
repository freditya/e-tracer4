/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.repositories;

import etracer.com.projectetracer.entities.Department;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Relion31
 */
@Repository
public interface DepartmentRepository extends CrudRepository<Department, String>{
    @Query(
            value = "SELECT d.departmentId, d.departmentName, d.villageId, d.employeeId, d.isDelete \n"
            + "FROM department d\n"
            + "JOIN village v ON d.villageId = v.villageId\n"
            + "JOIN employee e ON d.employeeId = e.employeeId\n"
            + "WHERE d.isDelete='false'",
            nativeQuery = true)
    List<Department> getAll();
}
