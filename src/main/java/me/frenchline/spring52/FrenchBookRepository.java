package me.frenchline.spring52;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/* using @Qualifier to identify the bean that should be consumed */
// @Qualifier는 Bean의 id
// 기본적으로 @Component 계열 애노테이션을 쓰면 Bean의 id는 소문자(small case)로 시작하는 클래스 이름과 동일하게 만들어진다
// 해당 Bean을 사용하는 쪽에서 @Qualifer("Bean의 id")를 명시하거나, 필드명을 동일하게 맞춘다 
@Repository
public class FrenchBookRepository implements BookRepository {
}
