package com.bellacode.homebudget;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class HomeBudgetApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeBudgetApplication.class, args);
    }
}