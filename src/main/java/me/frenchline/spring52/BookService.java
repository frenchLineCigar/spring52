package me.frenchline.spring52;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    List<BookRepository> bookRepositories; //BookRepository 타입의 모든 Bean 주입

    public void printBookRepository() {
//        this.bookRepositories.forEach(s -> System.out.println(s.getClass()));
        this.bookRepositories.forEach(System.out::println);
    }

}
