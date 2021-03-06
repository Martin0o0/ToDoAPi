package com.example.todolistapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.servlet.ServletContainerInitializer;


@EnableJpaAuditing //Auditiong 설정해주자.
@SpringBootApplication
public class TodoListApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoListApiApplication.class, args);
    }

}