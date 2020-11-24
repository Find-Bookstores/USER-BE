package com.example.tamchack.repository;

import com.example.tamchack.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByIdAndPw(String Id, String pw);
    User findByPw(String pw);
}
/*
 JpaRepository는 데이터 검색을 위한것
 Optional<User> findByEmail(String id);
 은 검색할 데이터를 메소드로 만든 것
 Optional은 모든 타입의 참조변수 저장이 가능, 널 값으로 발생하는 예외 처리 쉽게 가능
 */
