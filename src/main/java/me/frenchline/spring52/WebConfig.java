package me.frenchline.spring52;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 스프링 웹 MVC 설정 (스프링 부트 없이 스프링 MVC를 사용하는 경우)
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        //커스텀 컨버터 등록
        registry.addConverter(new EventConverter.StringToEventConverter()); //모든 Controller에 동작한다
    }
}
