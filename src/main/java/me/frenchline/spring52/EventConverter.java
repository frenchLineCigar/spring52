package me.frenchline.spring52;

import org.springframework.core.convert.converter.Converter;

public class EventConverter {

    /* Object 간 변환 가능한 일반적인 컨버터 */
    /* String -> Event 변환 */
    public static class StringToEventConverter implements Converter<String, Event> { //제네릭 타입으로 Source와 Target을 받는다
        @Override
        public Event convert(String source) {
            return new Event(Integer.parseInt(source));
        }
    }

    /* Event -> String 변환 */
    public static class EventToStringConverter implements Converter<Event, String> {
        @Override
        public String convert(Event source) {
            return source.getId().toString();
        }
    }

    /* org.springframework.core.convert.converter.Converter
    1. 상태 정보 없음(Stateless) = Thread-Safe
    2. 상태정보가 없기 때문에 얼마든지 Bean으로 등록해서 써도 상관없다: ConverterRegistry에 등록해 사용
    */
}
