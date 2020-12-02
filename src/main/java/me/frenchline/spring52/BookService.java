package me.frenchline.spring52;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired @Qualifier("frenchBookRepository") //주입받을 Bean의 이름을 명시
    BookRepository bookRepository;

    /* BookService에 어떤 BookRepository 타입의 Bean이 주입이 되었는지 출력하는 메서드 */
    public void printBookRepository() {
        System.out.println(bookRepository.getClass());
    }

}
