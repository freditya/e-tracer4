/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
//import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import etracer.com.projectetracer.services.UserDetailServiceImpl;

/**
 *
 * @author Relion31
 */
//@Configuration
//@EnableWebSecurity
public class WebConfig {
    
//     String[] resources = new String[]{
//        "/include/**", "/css/**", "/icons/**", "/img/**", "/js/**", "/layer/**"
//    };
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers(resources).permitAll()
//                .antMatchers("/", "/index").permitAll()
//                .antMatchers("/assets/**").permitAll() 
//                .antMatchers("/admin*").access("hasRole('ADMIN')")
//                .antMatchers("/user_role*").access("hasRole('USER') or hasRole ('ADMIN')")
//                .antMatchers("/manager*").access("hasRole('MANAGER')")
//                .antMatchers("/trainer*").access("hasRole('TRAINER')")
//                .anyRequest().authenticated()
//                .and()
//                . formLogin()
//                . loginPage("/login")
//                . permitAll()
//                . defaultSuccessUrl("/dashboard")
//                . failureUrl("/login? error = True")
//                . usernameParameter("username")
//                . passwordParameter("password")
//                . and ()
//                .logout()
//                .permitAll()
//                .logoutSuccessUrl("/login?logout");
//
//    }
//    BCryptPasswordEncoder bCryptPasswordEncoder;
//    
//     @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
////El numero 4 representa que tan fuerte quieres la encriptacion.
////Se puede en un rango entre 4 y 31. 
////Si no pones un numero el programa utilizara uno aleatoriamente cada vez
////que inicies la aplicacion, por lo cual tus contrasenas encriptadas no funcionaran bien
//        return bCryptPasswordEncoder;
//    }
//    
//     @Autowired
//    UserDetailServiceImpl userDetailsService;
//     
//
//    //Registra el service para usuarios y el encriptador de contrasena
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//
//        // Setting Service to find User in the database.
//        // And Setting PassswordEncoder
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
//


}
