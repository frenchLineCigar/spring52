package me.frenchline.spring52;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/* Client */
@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    EventService eventService; //@Primary인 ProxySimpleEventService 타입의 빈이 주입

    @Override
    public void run(ApplicationArguments args) throws Exception {
        eventService.createEvent();
        eventService.publishEvent();
        eventService.deleteEvent();
    }
}
