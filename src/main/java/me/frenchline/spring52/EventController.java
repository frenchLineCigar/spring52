package me.frenchline.spring52;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @GetMapping("/event/{id}")
    public String getEvent(@PathVariable Integer id) {
        System.out.println(id);
        return id.toString();
    }

}
