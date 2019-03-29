package com.bellacode.homebudget;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class HomeBudgetApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(HomeBudgetApplication.class, args);
    }
}