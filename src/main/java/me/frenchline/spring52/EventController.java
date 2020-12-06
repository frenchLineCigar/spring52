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

    /**
     * 이전 PropertyEditor를 DataBinder를 통해서 사용했다면
     * 지금 Converter와 Formatter는 ConversionService를 통해 사용한다.
     * 타입을 변환하는 작업은 DataBinder 대신에
     * Converter와 Formatter를 활용할 수 있게 해주는 ConversionService가 변환 작업을 하게 되는 것이다.
     *
     * 스프링 웹 MVC 설정에 WebMvcConfiguration 인터페이스의 addFormatters를 오버라이딩해 등록되는
     * Formatter와 Converter들은 ConversionService에 등록이 되고, ConversionService를 통해 실제 변환 작업을 한다.
     * 그리고 이 ConversionService 빈을 스프링 MVC, 스프링 XML 빈(value) 설정 파일, SpEL에서 사용한다.
     *
     * ConversionService의 Bean으로 DefaultFormattingConversionService가 자주 사용된다.
     * DefaultFormattingConversionService 클래스가는 FormatterRegistry, ConversionService 라는 2가지 인터페이스 구현했다.
     * 따라서 두 인터페이스의 기능을 한다. 여러 기본 컨버터와 포매터를 등록해준다. (기본 타입 변환 기능들이 이미 모두 내장됨)
     * (FormatterRegistry는 사실상 ConverterRegistry를 상속받고 있음) FormatterRegistry에 ConverterRegistry를 등록할 수 있다
     *
     */

}
