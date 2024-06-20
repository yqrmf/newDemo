package com.example.newdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.newdemo.demos.web")
public class NewDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(NewDemoApplication.class, args);
    }

}
