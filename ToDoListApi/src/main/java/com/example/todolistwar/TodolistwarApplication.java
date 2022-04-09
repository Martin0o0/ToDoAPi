package com.example.todolistwar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing //Auditiong 설정해주자.
@SpringBootApplication
public class TodolistwarApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodolistwarApplication.class, args);
    }

}
