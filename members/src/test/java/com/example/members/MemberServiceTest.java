package com.example.members;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberServiceTest {
    private final MemberService service = new MemberService(new MemberRepository());

    @Test
    void matchMember(){
        assertThat(service.search("田")).hasSize(2);
    }

    @Test
    void notMatchMember(){
        assertThat(service.search("A")).isEmpty();
    }

    @Test
    void allWithVoid(){
        assertThat(service.search("")).hasSize(5);
    }
}
