package com.example.members;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public List<Member> search(String keyword){
        List<Member> memberList = repository.findAll();

        if(keyword == null || keyword.isBlank()){
            return memberList;
        }
        String k = keyword.trim();
        return memberList.stream()
                .filter(m -> m.name().contains(k))
                .toList();
    }

    public Optional<Member> findById(long id) {
        return repository.findAll().stream()
                .filter(m -> m.id() == id)
                .findFirst();
    }
}
