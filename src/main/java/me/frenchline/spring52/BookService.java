package me.frenchline.spring52;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository frenchBookRepository; //필드명을 동일하게 맞춘다

    /* BookService에 어떤 BookRepository 타입의 Bean이 주입이 되었는지 출력하는 메서드 */
    public void printBookRepository() {
        System.out.println(frenchBookRepository.getClass());
    }

}
