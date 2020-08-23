package com.Schelper;

import com.Schelper.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.assertj.core.internal.bytebuddy.implementation.FixedValue.value;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/*
    @RunWith(SpringRunner.class)
    테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킨다.
    여기서는 SpringRunner라는 스프링 실행자를 사용한다.
    즉, 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 하게 된다.
 */
@RunWith(SpringRunner.class)

/*
    @WebMvcTest
    여러 스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 어노테이션
    선언할 경우 @Controller, @ControllerAdvice 등을 사용할 수 있다.
    단, @Service, @Component, @Repository 등은 사용할 수 없다.
 */
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    /*
        @Autowired
        스프링이 관리하는 Bean을 주입받는다.
     */
    @Autowired

    /*
        MockMvc
        웹 API를 테스트 할 때 사용한다.
        스프링 MVC 테스트의 시작점이다.
        이 클래스를 통해 HTTP GET, POST등에 대한 API 테스트를 진행할 수 있다.
     */
    private MockMvc mvc;

    @Test
    public void hello_return() throws Exception{

        String hello = "hello";

        /*
            MockMvc를 통해 /hello 주소로 HTTP GET요청을 한다.
            체이닝이 지원되어 아래와 같이 여러 검증기능을 이어서 선언할 수 있다.
         */
        mvc.perform(get("/hello"))
                .andExpect(status().isOk()) //mvc.perform 결과 중 HTTP header의 Status를 검증 200,404,500 등
                .andExpect(content().string(hello)); //mvc.perform 결과 중 응답 본문 내용을 검증한다.

    }

    @Test
    public void helloDto_return() throws Exception{

        String name = "hello";
        int    amount = 1000;

        mvc.perform(
                get("/hello/dto")
                .param("name" , name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.amount").value(amount));

    }

}
