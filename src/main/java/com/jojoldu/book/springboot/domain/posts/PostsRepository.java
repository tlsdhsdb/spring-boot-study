package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
//DB Layer 접근자
//데이터에 접근을 위한 객체 생성
public interface PostsRepository extends JpaRepository<Posts,Long>{

}
