package me.frenchline.spring52;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    /* PropertyEditor 사용 */
    @InitBinder //컨트롤러에서 사용할 바인더들을 등록 (전역적으로 등록할 수도 있다)
    public void init(WebDataBinder webDataBinder) { //DataBinder의 구현체 중 하나
        webDataBinder.registerCustomEditor(Event.class, new EventEditor()); //Event 클래스 타입을 처리할 PropertyEditor를 등록
    }

    @GetMapping("/event/{event}")
    public String getEvent(@PathVariable Event event) {
        System.out.println(event); //Event{id=1, title='null'}
        return event.getId().toString();
    }

}
