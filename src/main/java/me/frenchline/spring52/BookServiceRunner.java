package me.frenchline.spring52;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/* 실제 어떤 Bean이 주입되는지 확인하기 위한 Runner (*스프링 부트 강좌 참고) */
// 애플리케이션을 실행하면 애플리케이션이 구동된 다음에 Runner들을 다 호출한다
@Component
public class BookServiceRunner implements ApplicationRunner {

    @Autowired
    BookService bookService;

    /**
     * ApplicationRunner는 스프링 부트가 제공하는 인터페이스이고,
     * 애플리케이션이 완전히 구동된 이후에 일을 한다.
     * 따라서 가장 늦게 로그가 찍힘
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        bookService.printBookRepository();
    }
}

