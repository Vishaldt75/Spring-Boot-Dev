package com.springboot.curdDemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
/*import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;*/
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
   //Creating users with roles.
   /* @Bean
    public InMemoryUserDetailsManager userDetailsManager()
    {
        UserDetails john= User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();
        UserDetails merry= User.builder()
                .username("merry")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER")
                .build();
        UserDetails susan= User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john,merry,susan);
    }*/

    //add Support of JDBC and not hard coded users
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource)
    {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        //Define Query to retrieve user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id,pass,active from members where user_id=?");
        //Define Query to retrieve using roles.
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id,role from roles where user_id=?");
        return jdbcUserDetailsManager;
    }

    //Restrict Access based on roles.
    @Bean
    public SecurityFilterChain  filterChain(HttpSecurity http) throws Exception
    {
        http.authorizeHttpRequests(configure ->
                configure
                        .requestMatchers(HttpMethod.GET,"/magic-api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/magic-api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/magic-api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/magic-api/employees/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/magic-api/employees/**").hasRole("ADMIN")

        );
        //use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery
        //In General, Not Required for Stateless REST APIs that use Post Put DELETE and Patch.
        http.csrf(csrf->csrf.disable());

        return http.build();
    }
}
