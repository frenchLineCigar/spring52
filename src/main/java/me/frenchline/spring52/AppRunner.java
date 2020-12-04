package me.frenchline.spring52;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Resource resource = resourceLoader.getResource("classpath:test.txt"); //prefix를 명시적으로 사용하자
        System.out.println(resource.exists());
        System.out.println(resource.getDescription()); //리소스 설명
        System.out.println(Files.readString(Path.of(resource.getURI()))); //URI로 Path를 만들고 그 패스에 해당하는 파일을 읽어서 컨텐츠를 출력
    }
}
