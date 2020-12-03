package me.frenchline.spring52;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:/app.properties") //해당 위치의 properties파일을 PropertySource에 놓겠다
public class Spring52Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring52Application.class, args);
    }
}
