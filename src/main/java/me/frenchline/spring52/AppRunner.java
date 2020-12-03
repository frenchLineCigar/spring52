package me.frenchline.spring52;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    ApplicationContext ctx;

    @Autowired
    BookRepository bookRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Environment environment = ctx.getEnvironment(); //ApplicationContext extends EnvironmentCapable
        System.out.println(Arrays.toString(environment.getActiveProfiles())); //현재 활성화 된 Profiles
        System.out.println(Arrays.toString(environment.getDefaultProfiles())); //기본 Profiles: 어떤 Profile이든 상관없이 기본적으로 적용되는 Profile

        
    }
}
