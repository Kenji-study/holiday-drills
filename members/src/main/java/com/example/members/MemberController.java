package com.example.members;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class MemberController {
    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @GetMapping("/members")
    public String list(@RequestParam(required = false) String keyword,Model model) {
        model.addAttribute("members",service.search(keyword));
        model.addAttribute("keyword",keyword);
        return "members/list";
    }

    @GetMapping("/members/{id}")
    public String detail(@PathVariable long id, Model model) {
        Member member = service.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("member",member);
        return "members/detail";
    }
}
