package me.frenchline.spring52;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository myBookRepository; //주입받을 Bean의 이름과 동일하게 필드이름을 맞춘다

    public void printBookRepository() {
        System.out.println(myBookRepository.getClass());
    }

}
