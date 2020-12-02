package me.frenchline.spring52;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class BookService {

    BookRepository bookRepository;

    @Autowired(required = false)
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void printRepositoryClass() {
        if (bookRepository != null) System.out.println(bookRepository.getClass());
    }

}
