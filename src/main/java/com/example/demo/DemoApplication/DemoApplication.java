package com.example.demo.DemoApplication;
import java.sql.SQLException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@SpringBootConfiguration
@EntityScan(basePackages ={"Entity","DataForMap"}) 
@ComponentScan(basePackages= {"Controller","DTO","Service","DataForMap"})
@EnableJpaRepositories(basePackages = {"Repository","DataForMap"})
@EnableAutoConfiguration
public class DemoApplication {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		SpringApplication.run(DemoApplication.class, args);
	}
}


