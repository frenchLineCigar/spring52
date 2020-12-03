package me.frenchline.spring52;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 발생시킨 이벤트를 받아서 처리하는 핸들러
 * - Bean으로 등록해야 한다
 */
@Component
public class MyEventHandler implements ApplicationListener<MyEvent> { //Spring 4.2 이전에는 항상 ApplicationListener이란 인터페이스를 구현해야 했다

    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("이벤트 받았다. 데이터는 " + event.getData()); //event를 전달받아서 원하는 처리를 구현한다
        System.out.println("이벤트 받았다. 소스는 " + event.getSource()); //source를 전달받아서 원하는 처리를 구현한다
    }
}
