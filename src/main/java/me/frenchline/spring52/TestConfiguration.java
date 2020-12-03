package me.frenchline.spring52;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test") //이 Bean 설정파일은 "test" profile로 애플리케이션을 실행할 때만 사용된다
public class TestConfiguration {

    @Bean
    public BookRepository bookRepository() {
        return new TestBookRepository();
    }

}
