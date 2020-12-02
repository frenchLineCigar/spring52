package me.frenchline.spring52;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class BookService {

    @Autowired(required = false)
    BookRepository bookRepository;

    @PostConstruct
    public void printRepositoryClass() {
        if (bookRepository != null) System.out.println(bookRepository.getClass());
    }

}
