package me.frenchline.spring52;

import me.frenchline.out.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "me.frenchline") //아예 통째로 잡기
public class Spring52Application {

	@Autowired
	MyService myService;

	public static void main(String[] args) {
		SpringApplication.run(Spring52Application.class, args);
	}

}
