/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.services;

import etracer.com.projectetracer.entities.Role;
//import etracer.com.projectetracer.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Relion31
 */
@Service
public class UserDetailServiceImpl {
    
//    @Autowired
//    UserRepository userRepository;
//    
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         etracer.com.projectetracer.entities.User appUser = 
//                 userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Not exist"));
//   List grantList = new ArrayList();
//    for (Role authority: appUser.getAuthority()) {
//        // ROLE_USER, ROLE_ADMIN,..
//        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getRoleName());
//            grantList.add(grantedAuthority);
//    }
//    
//    //Crear El objeto UserDetails que va a ir en sesion y retornarlo.
//    UserDetails user = (UserDetails) new User(appUser.getUsername(), appUser.getPassword(), grantList);
//         return user;
//    }
}
