package me.frenchline.spring52;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    MessageSource messageSource;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(messageSource.getClass()); //Spring Boot의 경우 'messages'라는 Resource Bundle을 읽어들이는 ResourceBundleMessageSource가 이미 Bean으로 자동 등록되어 있다

        System.out.println(messageSource.getMessage("greeting", new String[]{"lucy"}, Locale.getDefault())); //getDefault: 운영체제의 기본값으로 읽어온다
        System.out.println(messageSource.getMessage("greeting", new String[]{"lucy"}, Locale.KOREA));
        System.out.println(messageSource.getMessage("greeting", new String[]{"lucy"}, Locale.US));
//        System.out.println(messageSource.getMessage("greeting", new String[]{"lucy"}, Locale.KOREAN));
//        System.out.println(messageSource.getMessage("greeting", new String[]{"lucy"}, Locale.ENGLISH));
    }
}
