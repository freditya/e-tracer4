/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.repositories;

import etracer.com.projectetracer.entities.Province;
import etracer.com.projectetracer.entities.UserRole;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Relion31
 */
@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {

    @Query(
            value = "select * from user_role u WHERE u.is_delete='false'",
            nativeQuery = true)
    List<UserRole> getAll();
//    @Query(
//            value = "select u.user_id, u.id, u.roleId, u.is_delete from user_role u \n"
//            + "JOIN user e ON e.id=u.id\n"
//            + "JOIN role r ON u.roleId=r.roleId WHERE u.is_delete='false'",
//            nativeQuery = true)
//    List<UserRole> getAll();
}
