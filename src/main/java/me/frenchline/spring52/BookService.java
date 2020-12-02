package me.frenchline.spring52;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @Autowired 동작 원리
 * 1. 어떻게 동작하는가? BeanPostProcessor 라는 라이프사이클 인터페이스의 구현체에 의해서 동작을 한다.
 * 2. BeanPostProcessor가 무엇인가?
 *  - 새로 만든 빈 인스턴스를 수정할 수 있는 수정할 수 있는 라이프 사이클 인터페이스
 *  - Bean의 인스턴스 생성 -> BeanPostProcessor -> Bean 초기화(Initialization) -> BeanPostProcessor -> ...
 *  1) Bean의 인스턴스를 만든 후에는 Bean의 초기화(Initialization) 라이프사이클이 또 있다.
 *  2) 초기화 라이프사이클 이전 또는 이후에 어떤 부가적인 작업을 할 수 있는  또 다른 라이프사이클 콜백(callback)이 존재한다.
 *  3) 그게 바로 BeanPostProcessor 인터페이스다.
 *  >참고: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/config/BeanPostProcessor.html
 * 3. Initialization이란 무엇인가? Bean 인스턴스가 만들어진 다음 이뤄지는 부가적인 작업
 *  방법 1) @PostConstruct(해당 Bean이 만들어진 다음에 처리할 것) 애노테이션을 사용한 초기화 정의
 *  방법 2) implements InitializingBean 시 afterPropertiesSet() 메서드 오버라이딩를 통한 초기화 정의
 * 4. AutowiredAnnotationBeanPostProcessor
 *  - 스프링이 제공하는 @Autowired와 @Value 애노테이션 그리고 JSR-330의 @Inject 애노테이션을 지원하는 애노테이션 처리기
 * 1) 아래 Bean 생명주기를 보면 InitializingBean's afterPropertiesSet 앞, 뒤로 BeanPostProcessors의 콜백 메서드가 감싸고 있음을 알 수 있다
 * 2) postProcessBeforeInitialization, postProcessAfterInitialization 란 2가지의 메서드 콜백을 제공해준다
 * 3) 그 중 AutowiredAnnotationBeanPostProcessor가 동작해서 @Autowired란 애노테이션을 처리해준다
 * 4) 처리해 준다는 의미? 해당 타입의 빈을 찾아서 주입해 준다는 뜻
 * 5) 언제 주입해 주는가? postProcessBeforeInitialization 시점에 주입 즉, 빈 초기화 전에 주입 해준다
 */
@Service
public class BookService implements InitializingBean {

    @Autowired
    BookRepository myBookRepository; //주입받을 Bean의 이름과 동일하게 필드이름을 맞춘다

    public void printBookRepository() {
        System.out.println("BookService.printBookRepository");
        System.out.println(myBookRepository.getClass());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("BookService.afterPropertiesSet");
        System.out.println(myBookRepository.getClass());
    }

    @PostConstruct
    public void setUp() {
        System.out.println("BookService.setUp");
        System.out.println(myBookRepository.getClass());
    }

    /**
     * Bean 생명 주기(lifecycle)
     * ● BeanFactory 인터페이스 : ApplicationContext 인터페이스가 BeanFactory의 하위 인터페이스다.
     * > 참고: https://docs.spring.io/spring-framework/docs/5.0.8.RELEASE/javadoc-api/org/springframework/beans/factory/BeanFactory.html
     *
     * Bean factory implementations should support the standard bean lifecycle interfaces as far as possible. The full set of initialization methods and their standard order is:
     * (..생략..)
     * =====================================================================
     *  11. `postProcessBeforeInitialization` methods of `BeanPostProcessors` (빈 초기화 전)
     *  ====================================================================
     *  12. `InitializingBean's afterPropertiesSet` (빈 초기화)
     *  13. a custom init-method definition
     *  ====================================================================
     *  14. `postProcessAfterInitialization` methods of `BeanPostProcessors` (빈 초기화 후)
     *  ====================================================================
     *  (..생략..)
     */
}
