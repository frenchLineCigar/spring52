package me.frenchline.spring52;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository @Primary
public class FrenchBookRepository implements BookRepository {
}
