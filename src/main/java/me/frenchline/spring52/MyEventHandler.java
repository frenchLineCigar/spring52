package me.frenchline.spring52;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.RequestHandledEvent;

@Component
public class MyEventHandler {

    @EventListener
    @Async
    public void handle(MyEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("이벤트 받았다. 데이터는 " + event.getData());
    }

    @EventListener
    @Async
    public void handle(ContextRefreshedEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("ContextRefreshedEvent");
        //var applicationContext = event.getApplicationContext();
    }

    @EventListener
    @Async
    public void handle(ContextStartedEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("ContextStartedEvent");
        //var applicationContext = event.getApplicationContext();
    }

    @EventListener
    @Async
    public void handle(ContextStoppedEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("ContextStoppedEvent");
        //var applicationContext = event.getApplicationContext();
    }

    @EventListener
    @Async
    public void handle(ContextClosedEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("ContextClosedEvent");
        //var applicationContext = event.getApplicationContext();
    }

    @EventListener
    @Async
    public void handle(RequestHandledEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("RequestHandledEvent");
        //var applicationContext = event.getApplicationContext();
    }
}
