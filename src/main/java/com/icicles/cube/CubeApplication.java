package com.icicles.cube;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.icicles.cube.DAO")
public class CubeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CubeApplication.class, args);
    }

}
