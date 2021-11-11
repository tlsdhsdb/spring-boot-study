package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//스프링부트의 자동설정 및 스프링 Bean 일기과 생성을 모두 자동으로 설정해준다.
//이 명령어가 있는 위치부터 설정을 읽어가기 때문에 항상 프로젝트의 최상단에 위치해야합니다.
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
        //main에서 실행하는 SpringApplication으로 인해 내장 WAS(web application server) 실행할수있게됨
        //이것 덕분에 별도의 was를 두지않고 어플리케이션을 실행할 때 내부에서 was가 실행된다.
        //항상 톰캣을 설치할 필요가 없으며 스프링 부트로 만들어진 jar 파일로 실행하면 된다.
        //언제 어디서나 같은 환경에서 스프링부트를 배포 할 수 있기 때문에 내장 WAS를 사용하는 것을 권장

        //내장 WAS를 쓰지 않을 경우 -> 모든 서버가 WAS의 종류와 버전 설정을 일치시켜야만 함!
    }

}
