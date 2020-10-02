package com.myTwitterAPI.autoNetBE;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.web.servlet.FilterRegistrationBean;

import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AutoNetBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoNetBeApplication.class, args);
	}
           @Bean   
        public FilterRegistrationBean<CorsFilter> simpleCorsFilter() {
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowCredentials(true);
            config.setAllowedOrigins(Collections.singletonList("*"));
            config.setAllowedMethods(Collections.singletonList("*"));
            config.setAllowedHeaders(Collections.singletonList("*"));
            source.registerCorsConfiguration("/**", config);
            FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
            bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
            
            return bean;
        }
     
        	
        
        
        @EnableWebSecurity
        @Configuration
        class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
                                .antMatchers(HttpMethod.GET, "/").permitAll()
                                .antMatchers(HttpMethod.GET, "/getUsuario").permitAll()
                                .antMatchers(HttpMethod.POST, "/nuevoUsuario").permitAll()
                                .antMatchers(HttpMethod.POST, "/login").permitAll()
				.anyRequest().authenticated();
		}
        }

}
