package me.frenchline.spring52;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

public class EventValidator {

    /* 이 EventValidator는 Event 클래스 타입의 인스턴스를 검증한다 */
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Event.class); //파라미터로 전달되는 클래스 타입이 이벤트인지 확인
//        return Event.class.isAssignableFrom(clazz);
    }

    /* 실제 검증 로직 */
    public void validate(Object target, Errors errors) {
        //1. ValidationUtils 활용
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "notEmpty", "Empty title is not allowed.");
        
        //2. 직접 조건 작성
//        Event event = (Event) target;
//        if (event.getTitle() == null) {
//            errors.rejectValue("title", "notEmpty", "Empty title is not allowed.");
//        }
    }
}
