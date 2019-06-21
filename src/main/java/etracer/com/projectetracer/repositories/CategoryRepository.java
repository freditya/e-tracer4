/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.repositories;

import etracer.com.projectetracer.entities.Assessment;
import etracer.com.projectetracer.entities.Category;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author yosef
 */
public interface CategoryRepository extends CrudRepository<Category, String>{

    @Query(
            value = "SELECT * from category where isDelete = 'false'", nativeQuery = true)
    List<Category> getAll();
}
