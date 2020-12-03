package br.com.educ4.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests( a -> a
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST,"/**").permitAll() // TODO colocar segurança nessa rota
                .anyRequest().authenticated()
        ).oauth2Login();
    }

}
