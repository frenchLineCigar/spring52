package me.frenchline.spring52;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring52Application implements ExitCodeGenerator {

    public static void main(String[] args) {
        SpringApplication.run(Spring52Application.class, args);
    }

    @Override
    public int getExitCode() { //디버그 모드에만 작동함
        return 130;
    }
}
