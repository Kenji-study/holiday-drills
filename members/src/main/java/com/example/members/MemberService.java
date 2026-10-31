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

        if(keyword == null || keyword.isBlank()){
            return repository.findAll();
        }

        String k = keyword.trim();
        return repository.findByKeyword(k);
    }

    public Optional<Member> findById(long id) {
        return repository.findById(id);
    }
}
