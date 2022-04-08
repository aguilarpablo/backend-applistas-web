package com.suez.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MainConfig {
	
	@Bean
    WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(final CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("*").allowedOrigins("http://localhost:8081").allowCredentials(true);
            }
        };
    }


}
