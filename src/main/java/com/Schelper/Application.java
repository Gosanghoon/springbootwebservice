package com.Schelper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication
public class Application {
    public static void main(String[] args){

         /*
            SpringApplication.run 메소드로 내장 WAS를 실행시킨다.
            이렇게 되면 항상 서버에 톰캣을 설치할 필요가 없게되고, 스프링부트로 만들어진 jar 파일(실행가능한 JAVA 패키징파일)
            로 실행하면 된다.
         */
        SpringApplication.run(Application.class, args);

    }

}
