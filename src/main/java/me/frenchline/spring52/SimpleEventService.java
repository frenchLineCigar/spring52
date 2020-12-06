package me.frenchline.spring52;

import org.springframework.stereotype.Service;

/* Real Subject */
@Service
public class SimpleEventService implements EventService {
    @Override
    public void createEvent() {
        long begin = System.currentTimeMillis(); //Crosscutting Concern

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Created an event");

        System.out.println(System.currentTimeMillis() - begin); //Crosscutting Concern
    }

    @Override
    public void publishEvent() {
        long begin = System.currentTimeMillis(); //Crosscutting Concern

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Published an event");

        System.out.println(System.currentTimeMillis() - begin); //Crosscutting Concern
    }

    @Override
    public void deleteEvent() {
        System.out.println("Delete an Event");
    }
}
