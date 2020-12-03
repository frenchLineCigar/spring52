package me.frenchline.spring52;

import me.frenchline.out.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootApplication //same as @Configuration @ComponentScan @EnableAutoConfiguration
public class Spring52Application {

    @Autowired
    MyService myService;

    public static void main(String[] args) {
        /**
         * 스프링 부트로 애플리케이션 구동하는 방법
         */
        /* 1. static method (run)를 사용하는 방법 */
//		SpringApplication.run(Spring52Application.class, args);

        /* 2. instance를 만들어서 사용하는 방법 */
        var app = new SpringApplication(Spring52Application.class); //var 라는 지역 변수(local variable) 사용 가능 (java 10+)
        // Functional한 설정
        // addInitializers: 함수적으로 원하는 ApplicationContext를 주입받을 수 있다
        // registerBean: 함수적으로 직접 Bean을 등록할 수 있다
        app.addInitializers((ApplicationContextInitializer<GenericApplicationContext>) ctx -> {
            ctx.registerBean(MyService.class);
            ctx.registerBean(ApplicationRunner.class, () -> args1 -> System.out.println("Functional Bean Definition!!"));
        });
        app.run(args);

        /* 3. builder를 사용하는 방법 */
//        new SpringApplicationBuilder()
//                .sources(Spring52Application.class)
//                .initializers((ApplicationContextInitializer<GenericApplicationContext>) ctx -> {
//                    ctx.registerBean(MyService.class);
//                    ctx.registerBean(ApplicationRunner.class, () -> args1 -> System.out.println("Functional Bean Definition!!"));
//                })
//                .run(args);

    }

    /**
     * ComponentScan 중요 속성 2가지가 있다.
     * 1. 스캔 범위 설정: 하나는 어디부터 어디까지 스캔할 것인가?
     * 2. 필터 설정: 스캔 중 어떤 것들을 걸러낼 것인가?
     *
     * 스캔 기본 시작 위치는 @ComponentScan이 붙은 @Configuration부터 스캔하기 시작한다.
     * 따라서 현재 메인 애플리케이션 클래스가 시작 위치가 된다.
     *
     * 기본적으로는 @Component 애노테이션를 갖고 있는 것(@Repository, @Service, @Controller, @Configuration)들이 Bean으로 등록된다.
     * 단지 단점은 ApplicationContext의 경우 이러한 싱글톤 스코프(Singleton Scope)의 빈들은 초기에 다 생성을 한다.
     * 그렇기 때문에 초기에 등록해야 되는 빈이 많은 경우에 애플리케이션 구동 시간이 오래 걸릴 수가 있다는 단점이 있다.
     * 그런 단점이 있지만 어디까지나 그건 애플리케이션 구동 타임에 한번 약간의 성능을 먹는 거고,
     * 일단 구동이 되면 그 다음부터는 또 다른 빈을 만드느라 성능을 잡아먹는 일은 없으므로 크게 문제가 되지 않는다고 생각한다.
     * 하지만 구동 시간에 예민하다면 다른 방법을 고려할 수가 있다.
     * 다른 방법 중의 하나가 스프링 5부터 들어간 Functional 빈 등록이다.
     *
     * Spring 5 Functional Bean Registration
     * 참고 : https://www.baeldung.com/spring-5-functional-beans
     *
     * 이 방법 같은 경우에는 리플렉션(Reflection), cglib를 사용한 프록시(Proxy) 기법을 사용하지 않기 때문에 (이 2가지 기법은 성능에 영향을 준다)
     * Funtional 빈 등록 방법 같은 경우에는 그러한 기술을 전혀 사용하지 않아도 되기 때문에 성능 상의 이점이 조금이나마 있다.
     * 그런데 이 성능 상의 이점이라면 애플리케이션 구동 타임에 성능을 의미한다.
     *
     *
     */
}
