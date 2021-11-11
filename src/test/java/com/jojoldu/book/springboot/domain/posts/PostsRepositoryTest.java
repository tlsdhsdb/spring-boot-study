package com.jojoldu.book.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest

public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    //단위 테스트가 끝날 때마다 수행되는 메소드
    //삭제하는 메소드로 작성함
    public void cleanup(){
        postsRepository.deleteAll();
    }
    @Test
    public void 게시글저장_불러오기(){
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("onyoo@gmail.com")
                .build()
        );
        //테이블 posts에 insert/update 쿼리를 실행함
        //id값이 있다면 update 없다면 insert 쿼리가 실행 된다

        //when
        List<Posts> postsList = postsRepository.findAll();
        //posts 테이블에 있는 모든 데이터를 조회해오는 메소드

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);



    }
}
