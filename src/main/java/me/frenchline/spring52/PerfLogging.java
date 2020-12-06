package me.frenchline.spring52;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 이 애노테이션을 사용하면 성능을 로깅해 줍니다.
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD})
@Documented
public @interface PerfLogging {
}

/**
 * @Retention(속성)
 * 이 애노테이션 정보를 언제까지 유지할 것인가? 다음 속성 값에 따라 다르다.
 * 1. RetentionPolicy.CLASS (default): 컴파일 후 클래스 파일(.class) 내에도 애노테이션 정보가 남아있다
 * 2. RetentionPolicy.RUNTIME: 런타임 때까지, 굳이 런타임까지 유지할 필요는 없다
 * 3. RetentionPolicy.SOURCE: 소스 코드 내에서만, 컴파일 되면 사라짐
 * @Target : 애노테이션 유효 스코프
 * @Documented : JavaDoc 만드는 경우
 */