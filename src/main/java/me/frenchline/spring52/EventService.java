package me.frenchline.spring52;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @NonNull //return에 null 허용 x
    public String createEvent(@NonNull Event event) { //param에 null 허용 x
//        return "hello " + event.getName();
        return null;
    }
}
