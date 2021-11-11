package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

//컨트롤러를 json 으로 반환하는 컨트롤러로 만들어주는 역할을 합니다.
public class HelloController {
    @GetMapping("/hello")
    //HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어 줍니다.
    public String hello(){
        return "hello";
    }
    // /hello로 요청이 오면 문자열 hello를 반환하는 기능을 가지게 되었음.
    // 이 코드를 테스트 코드를 이용하여 검증해볼 것

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,@RequestParam("amount") int amount){
        return new HelloResponseDto(name,amount);
    }
}
