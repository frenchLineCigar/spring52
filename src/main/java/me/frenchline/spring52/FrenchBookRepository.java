package me.frenchline.spring52;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/* marking one of the beans as @Primary */
// 여러가지 BookRepository 타입이 있지만 그중 @Primary가 붙은 타입을 주로 사용할 것이다
// BookRepository 타입의 여러가지 빈을 주입해야 되는 경우에 @Primary가 붙은 타입의 빈을 반드시 주입하도록 마킹
@Repository @Primary
public class FrenchBookRepository implements BookRepository {
}
