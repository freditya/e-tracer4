/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.repositories;

import etracer.com.projectetracer.entities.ReportProblem;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yosef
 */
@Repository
public interface ReportProblemRepository extends CrudRepository<ReportProblem, String> {
    @Query(
            value = "SELECT rp.reportId, rp.reportMessage, rp.reportDate, rp.employeeId, rp.isDelete \n"
            + "FROM report_problem rp\n"
            + "JOIN employee e ON rp.employeeId = e.employeeId\n"
            + "WHERE rp.isDelete='false'",
            nativeQuery = true)
    List<ReportProblem> getAll();
}
