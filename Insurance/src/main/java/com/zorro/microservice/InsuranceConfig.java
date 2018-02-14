package com.zorro.microservice;


//import java.util.Arrays;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
@EnableWebSecurity
public class InsuranceConfig extends WebSecurityConfigurerAdapter{

	 /** Public URLs. */
    private static final String[] PUBLIC_MATCHERS = {
            "/",            
            "/insurance/**"
    };
    
    
	protected void configure(HttpSecurity http) throws Exception {
    	

            http.csrf().disable();
            http.headers().frameOptions().disable();

	
        http
                .authorizeRequests()
//                .antMatchers(PUBLIC_MATCHERS).permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
//                .formLogin().loginPage("/login").defaultSuccessUrl("/payload")
//                .failureUrl("/login?error").permitAll()
//                .and()
//                .logout().permitAll();
    }
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

//				auth
//					.userDetailsService(userSecurityService)
//					.passwordEncoder(passwordEncoder());
		        auth
		        	.inMemoryAuthentication()
		        	.withUser("user").password("password")
		        	.roles("USER");
    }

	
}
