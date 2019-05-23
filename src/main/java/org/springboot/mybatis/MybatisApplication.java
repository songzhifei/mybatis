package org.springboot.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@ServletComponentScan
// mapper 接口类扫描包配置
@MapperScan("org.springboot.mybatis.dao")
public class MybatisApplication extends SpringBootServletInitializer {

    @RequestMapping("/home")
    public String home(){
        return "hello world";
    }
    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MybatisApplication.class);
    }
}
