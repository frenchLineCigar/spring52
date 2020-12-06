package me.frenchline.spring52;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class EventFormatter implements Formatter<Event> { //포매터로 처리할 타입 하나만 준다

    /* 조금 더 Web에 특화되어 있는 포매터 */
    /* 문자를 받아서 객체로 (+ Locale 정보 기반으로 추가 처리 가능) */
    @Override
    public Event parse(String text, Locale locale) throws ParseException {

        return new Event(Integer.parseInt(text));
    }

    /* 객체를 받아서 문자열로 (+ Locale 정보 기반으로 추가 처리 가능) */
    @Override
    public String print(Event object, Locale locale) {
        return object.getId().toString();
    }

    /* org.springframework.format.Formatter<T>
    1. Thread-Safe = 상태 정보 없음(Stateless) = Bean으로 등록해 쓸 수 있다 => 다른 Bean을 주입받을 수 있다
    2. MessageSource를 주입받아 Locale 정보로 추가 작업 할 수 있다
    */
}
