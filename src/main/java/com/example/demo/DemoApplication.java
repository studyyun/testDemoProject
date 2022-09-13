package com.example.demo;

/*import com.test.demo.annotation.EnableDemoConfiguration;
import com.test.demo.config.DemoProperties;
import com.test.demo.service.DemoService;*/
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages = "com.example.demo.mapper")
@EnableScheduling
//@EnableDemoConfiguration
public class DemoApplication {

    /*@Autowired
    private DemoService demoService;

    @Autowired
    private DemoProperties demoProperties;*/

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    /*@PostConstruct
    public void init(){
        demoService.print();
        System.out.println("2#@!#!@"+demoProperties.getAge());
    }*/

}
