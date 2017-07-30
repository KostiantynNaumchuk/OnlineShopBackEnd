package com.myname.security.config;

import com.myname.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserService userService;


    @Bean
    public PasswordEncoder bcryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws  Exception{

       auth.
               userDetailsService(userService)
               .passwordEncoder(bcryptPasswordEncoder());
    }

    @Override
    protected  void configure(HttpSecurity http) throws  Exception{

        /*
         * CSRF protection is disabled. I real life service has to be enabled and properly configured
         */
         http.csrf().disable();

         /*
         * Configuration to disable sessions
         * */
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests()
              .antMatchers("/manage/**").hasRole("ADMIN")
              .antMatchers("/**").hasAnyRole("USER","SUPERUSER","ADMIN")
              .and().httpBasic();

    }

}
