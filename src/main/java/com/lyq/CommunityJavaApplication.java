package com.lyq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lyq.mapper")
public class CommunityJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunityJavaApplication.class, args);
    }

}
