package com.example.members;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepository {
    private final List<Member> members = List.of(
            new Member(1,"山田",30),
            new Member(2,"佐藤",25),
            new Member(3,"鈴木",41),
            new Member(4,"田中",28),
            new Member(5,"高橋",35)
    );

    public List<Member> findAll(){
        return members;
    }
}
