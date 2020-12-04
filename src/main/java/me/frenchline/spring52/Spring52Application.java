package me.frenchline.spring52;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ResourceLoader;

@SpringBootApplication
public class Spring52Application implements ExitCodeGenerator {

    @Autowired
    ResourceLoader resourceLoader;

    public static void main(String[] args) {
        SpringApplication.run(Spring52Application.class, args);
    }

    @Override
    public int getExitCode() { //디버그 모드에만 작동함
        return 130;
    }
}
