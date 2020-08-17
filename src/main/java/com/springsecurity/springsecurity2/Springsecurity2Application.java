package com.springsecurity.springsecurity2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.springsecurity.springsecurity2.mapper")
@SpringBootApplication
public class Springsecurity2Application {

    public static void main(String[] args) {
        SpringApplication.run(Springsecurity2Application.class, args);
    }

}
