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

        Resource resource = resourceLoader.getResource("classpath:test.txt");

        System.out.println(resource.exists());
        System.out.println(resource.getDescription()); //리소스 설명
        System.out.println(Files.readString(Path.of(resource.getURI()))); //URI로 Path를 만들고 그 패스에 해당하는 파일을 읽어서 컨텐츠를 출력
        System.out.println();
        System.out.println(resource.isFile()); //파일 인지
        System.out.println(resource.isReadable()); //읽을 수 있는지
        System.out.println(resource.isOpen()); //열려 있는지
        System.out.println(resource.getFilename()); //파일 이름
        System.out.println(resource.getURI());
        System.out.println(resource.getURL());
        System.out.println(resource.getFile());
//        System.out.println(resource.contentLength());
//        System.out.println(resource.lastModified());
//        System.out.println(resource.readableChannel());
    }
}
