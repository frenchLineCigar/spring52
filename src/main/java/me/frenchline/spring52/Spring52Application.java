package me.frenchline.spring52;

import me.frenchline.out.ComponentScanPkgConfig;
import me.frenchline.out.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication //same as @Configuration @EnableAutoConfiguration @ComponentScan
@Import(ComponentScanPkgConfig.class) //@Import 활용한 설정(@Configuration) 추가 임포트
public class Spring52Application {

	@Autowired
	MyService myService;

	@Autowired
	ComponentScanPkgConfig componentScanPkgConfig;

	public static void main(String[] args) {
		SpringApplication.run(Spring52Application.class, args);
	}

}
