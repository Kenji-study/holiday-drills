package com.example.members;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class MemberServiceTest {
    private final MemberService service = new MemberService(new MemberRepository());

    @Test
    void search_keywordMatches_returnsMatchingMembers() {
        assertThat(service.search("田"))
                .extracting(Member::name)
                .containsExactlyInAnyOrder("田中", "山田");
    }

    @Test
    void search_keywordNotMatches_returnsEmpty() {
        assertThat(service.search("A"))
                .isEmpty();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "　", "\t"})
    void search_nullOrBlankVariants_returnsAll(String keyword) {
        assertThat(service.search(keyword))
                .hasSize(5);
    }

    @Test
    void search_paddedWithSpaces_returnsMatchingMembers() {
        assertThat(service.search(" 田　"))
                .extracting(Member::name)
                .containsExactlyInAnyOrder("田中", "山田");
    }
}
