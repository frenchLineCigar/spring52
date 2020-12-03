package me.frenchline.spring52;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyEventController {

    @GetMapping("/event/{name}")
    public String hello(@PathVariable String name) {
        return "hello " + name;
    }
}