package me.frenchline.spring52;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AnotherHandler {

    @EventListener //이벤트를 처리하는 메서드 위에 추가한다
    @Async //비동기적으로 실행하고 싶은 경우 (당연히 순서는 보장이 안된다)
    public void handle(MyEvent myEvent) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("Another " + myEvent.getData());
    }

    /**
     * `@Async`를 사용해 비동기적으로 실행할 경우 당연히 순서는 보장이 안된다.
     * 비동기적(Async)으로 실행할 때는 각각의 쓰레드 풀(Thread Pool)에서 따로 놀기 때문에
     * 그리고 또 어떤 쓰레드(Thread)가 먼저 실행되는 지는 쓰레드 스케쥴링(Thread Scheduling)에 따라 달려 있으므로
     * 따라서 `@Order`가 더이상 의미가 없다.
     *
     * 그리고 이 상태에서 실행을 한다 하더라도 main 쓰레드에서 실행이 될 것이다. 한 쓰레드에서 실행됐으므로 비동기적이지 않고, 순차적이다.
     * 왜냐하면 @Async라는 애노테이션만 붙인다고 비동기적으로 동작하는 것이 아니기 때문이다.
     * 비동기적으로 실행하려면 @EnableAsync 를 사용해야 한다.
     * 또한 원래는 Thread Pool 관련된 설정을 더 해야 되는데, 지금 주제가 Async에 대한 것이 아니므로 생략하고,
     * 일단 간략하게만 default 쓰레드 풀로 돌게 하고 실행하면 Async하게 동작한다.
     */
}
