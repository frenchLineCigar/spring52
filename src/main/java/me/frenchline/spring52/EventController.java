package me.frenchline.spring52;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {


    @GetMapping("/event/{event}")
    public String getEvent(@PathVariable Event event) {
        System.out.println(event); //Event{id=1, title='null'}
        return event.getId().toString();
    }

}
