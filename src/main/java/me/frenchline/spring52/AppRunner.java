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
        while (true) {
            //System.out.println(messageSource.getMessage("greeting", new String[]{"lucy"}, Locale.getDefault())); //getDefault: 운영체제의 기본값으로 읽어온다
            System.out.println(messageSource.getMessage("greeting", new String[]{"lucy"}, Locale.KOREA));
            System.out.println(messageSource.getMessage("greeting", new String[]{"lucy"}, Locale.US));
            Thread.sleep(1000l); //1초마다 반복해서 콘솔을 찍으면서 다시 읽도록 (리소스를 캐쉬하는 시간이 최대 3초)
        }
    }
}
