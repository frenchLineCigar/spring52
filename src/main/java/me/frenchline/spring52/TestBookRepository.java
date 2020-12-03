package me.frenchline.spring52;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * 프로파일 표현식 : 아래 표현식은 조합이 가능
 * ● ! (not): 문자열 표현식에 NOT이라는 의미인 !를 사용할 수 있다
 * ● & (and)
 * ● | (or)
 *
 * Ex) @Profile("!prod & ( default | test )") //profile이 prod가 아니고, test 또는 default인 경우만 빈으로 등록
 * 위처럼 너무 복잡하게 쓸 필요 없다.
 * "항상 가장 간단하게 좋은 거다."
 * 현재 요구사항을 만족시킬 수 있는 가장 간단한 방법이 가장 좋은 방법이다.
 */
@Repository
@Profile("!prod")
public class TestBookRepository implements BookRepository {
}
