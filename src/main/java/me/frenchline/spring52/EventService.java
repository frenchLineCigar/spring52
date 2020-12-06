package me.frenchline.spring52;

import org.springframework.stereotype.Service;

@Service
public class EventService {

    public String createEvent(Event event) {
        return null; //Passing 'null' argument to parameter annotated as @NotNull
    }
}
