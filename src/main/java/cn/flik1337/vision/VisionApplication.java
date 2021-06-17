package cn.flik1337.vision;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan(value = {"cn.flik1337.vision.mbg.mapper","cn.flik1337.vision.dao","cn.flik1337.vision.mapper"})
public class VisionApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(VisionApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(VisionApplication.class, args);
    }

}
