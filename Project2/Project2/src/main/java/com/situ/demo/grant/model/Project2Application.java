package com.situ.demo.grant.model;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan(basePackages= {"com.situ.Project2.sys.controller,com.situ.Project2.sys.service"})
@MapperScan(value="com.situ.Project2.sys.mapper")
public class Project2Application {

	public static void main(String[] args) {
		SpringApplication.run(Project2Application.class, args);
	}

}