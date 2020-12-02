package me.frenchline.spring52;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService implements InitializingBean {

    @Autowired
    BookRepository bookRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("BookService.afterPropertiesSet");
        System.out.println(bookRepository.getClass());
    }

}
