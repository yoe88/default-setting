package com.spring.baseSetting.controller;

import com.spring.baseSetting.dto.Member;
import com.spring.baseSetting.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final MemberService memberService;

    public HomeController(MemberService memberService) {
        logger.info("HomeController Init...");
        this.memberService = memberService;
    }

    @GetMapping(path = "/")
    public String home() {
        return "index";
    }

    @GetMapping("/member")
    public ResponseEntity<List<Member>> members() {
        List<Member> members = memberService.getAllMemberList();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping("/member/{id}")
    public ResponseEntity<String> member(@PathVariable("id") String id){
        logger.info("입력한 id: {}",id);
        Member member = memberService.getMember(id);
        if(member == null){
            return new ResponseEntity<>("0", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("1", HttpStatus.OK);
        }
    }

    @PostMapping("/member/new")
    public String addMember(@ModelAttribute("member") Member member) {
        int result = memberService.addMember(member);
        return "redirect:/";
    }
}
