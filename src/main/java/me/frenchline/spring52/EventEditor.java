package me.frenchline.spring52;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

/* Event 변환용 프로퍼티 에디터 */
@Component
@Scope(value = "thread", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EventEditor extends PropertyEditorSupport { /* Object와 String 간의 변환만 가능하다 */

    /* Object -> String 변환 */
    @Override
    public String getAsText() {
        Event event = (Event) getValue();
        return event.getId().toString();
    }

    /* String -> Object 변환 */
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(new Event(Integer.parseInt(text)));
    }

    /*
    중요: PropertyEditor는 어떠한 경우에도 절대로 Bean으로 등록해서 쓰면 안된다!
    다시 말해 PropertyEditor의 구현체들은 여러 Thread에 공유해서 쓰면 절대로 안된다!
    [이유]
    getValue(), setValue()로 공유되고 있는 value는 PropertyEditorSupport가 가지고 있는 값이다
    이 값이 서로 다른 Thread에게 공유가 된다. 서로 다른 Thread에게 공유가 되기 때문에 Stateful(상태 정보 저장)하다.
    그래서 Thread Safe 하지 않다.
    Thread Safe 하지 않기 때문에 이 PropertyEditor의 구현체들은 여러 Thread에 공유해서 쓰면 안된다.
    즉 이말은 이 구현체들에 @Component 애노테이션 등을 붙여 Bean으로 등록해서 쓰면 안된다.
    심각한 문제가 발생한다. 절대로 PropertyEditor는 Bean으로 등록해서 쓰면 안된다.
    Ex) 1번 회원이 2번 회원 정보를 변경하고 있고, 2번 회원이 5번 회원 정보 변경하는 심각한 문제가 발생한다.
    PropertyEditor의 구현체들은 일반적인 Bean이 아니라 Thread Scope의 빈(한 Thread 내에서만 유효한 Scode의 Bean)으로 만들어서 쓰면 상관 없다.
    그럼 그나만 괜찮긴 하지만 Bean으로 전혀 등록을 안하는 것을 추천한다.
    */
}
