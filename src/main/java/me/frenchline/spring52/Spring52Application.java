package me.frenchline.spring52;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync //비동기적으로 실행하려면 @EnableAsync 를 사용
public class Spring52Application implements ExitCodeGenerator {

    public static void main(String[] args) {
        SpringApplication.run(Spring52Application.class, args);
    }

    /* 릴로딩 기능이 있는 메시지 소스 사용 */
    @Bean
    public MessageSource messageSource() {
        var messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(3); //리소스 캐쉬 시간: 최대 3초까지만 이 리소스를 캐싱하고 다시 읽도록 설정
        return messageSource;
    }

    @Override
    public int getExitCode() { //디버그 모드에만 작동함
        return 130;
    }
}
