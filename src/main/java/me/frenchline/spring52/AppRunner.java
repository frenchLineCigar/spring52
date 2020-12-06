package me.frenchline.spring52;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppRunner implements ApplicationRunner {

    /* SpEL (Spring Expression Language) */

    //1) #{“표현식"}
    @Value("#{1 + 1}") //표현식 평가(evaluation) 후
    int value; //결과 값을 프로퍼티에 할당

    @Value("#{'hello ' + 'world'}")
    String greeting;

    @Value("#{1 eq 1}")
    boolean trueOrFalse;

    @Value("hello")
    String hello;

    //2) ${“프로퍼티"}
    @Value("${my.value}")
    int myValue;

    //3) 표현식 안에는 프로퍼티를 사용할 수 있지만, 프로퍼티 안에서는 표현식을 사용할 수 없다
    @Value("#{${my.value} eq 100}")
    boolean isMyValue100;

    //4) Literal Expressions : 문자열 리터럴 그대로 할당
    @Value("#{'spring'}")
    String spring;

    //5) Inline Lists
    @Value("#{'1,2,3,4'}")
    List<Integer> numbers;

    @Value("#{{{'x, y'}, {'a, b'}}}")
    List listOfLists;

    //6) Bean References
    @Value("#{sample.data}")
    int sampleData;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("================");
        System.out.println(value);
        System.out.println(greeting);
        System.out.println(trueOrFalse);
        System.out.println(hello);
        System.out.println(myValue);
        System.out.println(isMyValue100);
        System.out.println(spring);

        System.out.println(numbers);
        int i = 0;
        for (Integer number : numbers) {
            System.out.println("idx["+i+"] = " + number);
            i++;
        }

        System.out.println(listOfLists);
        Object first = listOfLists.get(0);
        Object second = listOfLists.get(1);
        System.out.println("first = " + first);
        System.out.println("second = " + second);
        System.out.println(sampleData);

        /* SpEL의 기반 클래스 */
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("2 + 100");
        Integer value = expression.getValue(Integer.class);
        System.out.println(value);
    }
}
