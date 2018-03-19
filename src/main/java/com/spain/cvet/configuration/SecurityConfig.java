package com.spain.cvet.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.spain.cvet.filter.JwtFilter;
import com.spain.cvet.filter.LoginFilter;
import com.spain.cvet.service.impl.MyUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
        .antMatchers("/login").permitAll() //permitimos el acceso a /login a cualquiera
        .anyRequest().authenticated() //cualquier otra peticion requiere autenticacion
        .and()
        // Las peticiones /login pasaran previamente por este filtro
        .addFilterBefore(new LoginFilter("/login", authenticationManager()),
                UsernamePasswordAuthenticationFilter.class)
            
        // Las demás peticiones pasarán por este filtro para validar el token
        .addFilterBefore(new JwtFilter(),
                UsernamePasswordAuthenticationFilter.class);
	} 
        
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
		auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder);
	}

}
