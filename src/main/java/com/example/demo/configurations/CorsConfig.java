package com.example.demo.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200") // Cho phép Angular frontend
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Các method được phép
                        .allowedHeaders("*") // Chấp nhận tất cả headers
                        .allowCredentials(true); // Hỗ trợ cookies & auth
            }
        };
    }
}