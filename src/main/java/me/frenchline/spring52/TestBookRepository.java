package me.frenchline.spring52;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("test") //"test" profile에서 사용할 Repository다 (-Dspring.profiles.active="test")
public class TestBookRepository implements BookRepository {
}
