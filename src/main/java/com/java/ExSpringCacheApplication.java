package com.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ExSpringCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExSpringCacheApplication.class, args);
    }

}
