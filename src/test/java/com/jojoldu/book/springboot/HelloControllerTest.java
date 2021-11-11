package com.jojoldu.book.springboot;

import com.jojoldu.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.hamcrest.Matchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//여기서는 SpringRunner라는 스프링 실행자를 사용함
//스프링부트 테스트와 JUnit(자바의 단위테스트 도구) 사이에 연결자 역할을 함
@WebMvcTest(controllers = HelloController.class)
//Web에 집중 할 수 있는 스프링부트 어노테이션
//해당 어노테이션의 컨트롤러를 사용할것이기 때문에 작성한 코드
public class HelloControllerTest {

    @Autowired
    //스프링이 관리하는 Bean을 주입받음
    private MockMvc mvc;
    //웹 API를 테스트할 때 사용함
    //스프링 MVC 테스트의 시작점임
    //해당 클래스를 이용하여 HTTP GET,POST등에 대한 API 테스트를 할 수 있음

    @Test
    @WithMockUser
    //security 인증 없이 작동할수있게 하는 어노테이션
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
        //MockMvc를 통해 /hello 주소로 HTTP GET 요청을 합니다.
        //체이닝을 이용하여 여러가지 기능을 이어서 선언할 수 있다
        //Http header의 status를 검증합니다. 여기에서는 200상태인지 체크합니다
        //mvc.perform의 결과를 검증함 -> 응답 본문의 내용을 검증한다.
        //Controller 에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증함.
    }
    @Test
    @WithMockUser
    public void helloDto가_리턴된다() throws  Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name",name)
                        .param("amount",String.valueOf(amount)))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.name",is(name)))
                        .andExpect(jsonPath("$.amount",is(amount)));


    }
}
