/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.repositories;

import etracer.com.projectetracer.entities.EvaluationParameter;
import etracer.com.projectetracer.entities.Score;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Relion31
 */
@Repository
public interface ScoreRepository extends CrudRepository<Score, String> {

    @Query(
            value = "SELECT s.scoreId, s.score, s.evaluationId, s.isDelete FROM score s\n"
            + "JOIN evaluation_parameter e ON e.evaluationId=s.evaluationId\n"
            + "WHERE s.isDelete='false'",
            nativeQuery = true)
    List<Score> getAll();
}
