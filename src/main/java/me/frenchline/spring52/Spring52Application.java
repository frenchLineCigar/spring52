package me.frenchline.spring52;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring52Application implements ExitCodeGenerator {

    public static void main(String[] args) {
        //현재 스프링 애플리케이션을 기본적으로 웹 애플리케이션으로 구동해 주는데
        //웹 애플리케이션이 아닌 자바 메인 메서드 실행하듯이 서버 모드가 아닌 상태로 구동하는 방법
        SpringApplication app = new SpringApplication(Spring52Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }

    @Override
    public int getExitCode() { //디버그 모드에만 작동함
        return 130;
    }
}
