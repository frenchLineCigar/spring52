package me.frenchline.spring52;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 발생시킨 이벤트를 받아서 처리하는 핸들러
 * - Bean으로 등록해야 한다
 */
@Component
public class MyEventHandler { //Spring 4.2 이후부터는 제약사항이 사라졌다 (Spring Framework이 추구하는 철학: 비침투성)

    @EventListener //이벤트를 처리하는 메서드 위에 추가한다
    @Async //비동기적으로 실행하고 싶은 경우 (당연히 순서는 보장이 안된다)
    public void handle(MyEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("이벤트 받았다. 데이터는 " + event.getData());
    }
}
