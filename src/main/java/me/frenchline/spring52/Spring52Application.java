package me.frenchline.spring52;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
@PropertySource("classpath:/app.properties") //해당 위치의 properties파일을 PropertySource에 놓겠다
public class Spring52Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring52Application.class, args);
    }

    /* 릴로딩 기능이 있는 메시지 소스 사용 */
    // ReloadableResourceBundleMessageSource 등록
    // bean 이름은 항상 messageSource가 되야 한다
    @Bean
    public MessageSource messageSource() {
        var messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/messages");
        messageSource.addBasenames("classpath:/testdir/dev");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
