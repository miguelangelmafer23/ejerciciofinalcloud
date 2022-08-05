package com.bosonit.BackEmpresa.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {
    @Bean
    protected SecurityFilterChain configure (HttpSecurity http) throws Exception{
        http.csrf().disable()
                .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/h2-console").permitAll()

                //Solo puedes modificar los usuarios con rol ADMIN
                .antMatchers(HttpMethod.POST,"/api/v0/client").permitAll()
                .antMatchers(HttpMethod.GET,"/api/v0/client/{id}").hasAnyRole("USER","ADMIN")
                .antMatchers(HttpMethod.GET,"/api/v0/client/name/{name}").hasAnyRole("USER","ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/v0/client/{id}}").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/v0/client/{id}").hasRole("ADMIN")
                //


                .anyRequest().authenticated();
        return http.build();
    }

}
