/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.repositories;

import etracer.com.projectetracer.entities.RespondProblem;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yosef
 */
@Repository
public interface RespondProblemRepository extends CrudRepository<RespondProblem, String> {
    @Query(
            value = "SELECT res.respondId, res.respondMessage, res.reportId, res.employeeId, res.isDelete \n"
            + "FROM respond_problem res\n"
            + "JOIN report_problem rp ON res.reportId = rp.reportId\n"
            + "JOIN employee e ON res.employeeId = e.employeeId\n"
            + "WHERE res.isDelete='false'",
            nativeQuery = true)
    List<RespondProblem> getAll();
}
