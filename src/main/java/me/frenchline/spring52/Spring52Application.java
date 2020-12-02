package me.frenchline.spring52;

import me.frenchline.out.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"me.frenchline.out", "me.frenchline.spring52"}) //부분 지정
public class Spring52Application {

	@Autowired
	MyService myService;

	public static void main(String[] args) {
		SpringApplication.run(Spring52Application.class, args);
	}

}
