package me.frenchline.spring52;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 발생시킨 이벤트를 받아서 처리하는 핸들러
 * - Bean으로 등록해야 한다
 */
@Component
public class MyEventHandler { //Spring 4.2 이후부터는 제약사항이 사라졌다 (Spring Framework이 추구하는 철학: 비침투성)

    @EventListener //이벤트를 처리하는 메서드 위에 추가한다
    public void handle(MyEvent event) {
        System.out.println("이벤트 받았다. 데이터는 " + event.getData()); //event를 전달받아서 원하는 처리를 구현한다
        System.out.println("이벤트 받았다. 소스는 " + event.getSource()); //source를 전달받아서 원하는 처리를 구현한다
    }
}
