package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
//롬복 어노테이션
//클래스 내 모든 필드의 Getter 메소드를 자동생성
//Setter가 없는 이유 : 해당 클래스의 인스턴스 값들이 언제 어디스 변하는지 명확하게 구분이 힘들어 만들지 않음.
@NoArgsConstructor
//롬복 어노테이션
//기본 생성자 자동 추가 public Posts(){}
@Entity
//JPA 어노테이션
//테이블과 링크될 클래스임을 나타냄

//실제 DB테이블과 매칭될 클래스
//DB 데이터에 작업 할 경우에 실제 쿼리를 날리기보다는 엔티티 클래스의 수정을 통해 작업을 함
public class Posts {
    @Id
    //테이블의 PK 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //PK의 생성규칙을 나타낸다
    private Long id;

    @Column(length = 500,nullable = false)
    //테이블의 칼럼을 나타냄 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 된다
    //기본값 외의 추가로 변경이 필요하면 사용함
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)

    private String content;
    private String author;

    @Builder
    //해당 클래스의 빌더 패턴 클래스를 생성
    public  Posts(String title,String content,String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
