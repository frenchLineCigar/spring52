package me.frenchline.spring52;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    ApplicationContext messageSource;
    /**
     * MessageSource 관련된 기능은 ApplicationContext를 주입 받아 사용해도 된다. (ApplicationContext extends MessageSource 이므로)
     * 그런데 좋은 코딩 방법은 아니다.
     * 내가 쓰려는 기능을 정의한 인터페이스의 타입으로 쓰는 것이 더 적절하다.
     * 어떤 의도로 쓰는지 더 구체적이므로 좀 더 가독성이 높고 알기 쉽다.
     */

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
