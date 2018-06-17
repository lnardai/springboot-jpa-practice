package com.nardai.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PracticeApplication implements WebMvcConfigurer {


    /*For custom swagger UI, so csrf can be added */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html**").addResourceLocations("classpath:/static/swagger-ui.html");
    }


    public static void main(String[] args) {
        SpringApplication.run(PracticeApplication.class, args);
    }
}
