package me.frenchline.spring52;

import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class AnotherHandler {

    @EventListener //이벤트를 처리하는 메서드 위에 추가한다
    @Order(Ordered.HIGHEST_PRECEDENCE + 2) //순서가 중요한 경우 이렇게 순서를 정해준다
    public void handle(MyEvent myEvent) {
        // 쓰레드를 찍어서 순차적으로 실행되는지 확인
        // 순차적이란? 무엇이 먼저 실행될진 모르지만 A라는 핸들러가 실행이 되면, 그다음에 B라는 핸들러가 실행이 된다.
        // 핸들러 둘을 동시에 다른 Thread에서 실행해준다는 것이 아니라.
        System.out.println(Thread.currentThread().toString());
        System.out.println("Another " + myEvent.getData());
    }
}
