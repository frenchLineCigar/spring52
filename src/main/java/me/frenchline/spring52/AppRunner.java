package me.frenchline.spring52;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    ApplicationContext ctx;

    @Autowired
    BookRepository bookRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Environment environment = ctx.getEnvironment(); //ApplicationContext extends EnvironmentCapable
        //우선 순위 확인: VM Options vs. app.properties
        //계층형(Hierarchy) 쿼리니까 둘 중 하나만 이기게 된다
        System.out.println(environment.getProperty("app.name")); //VM Options Win!
    }
}
