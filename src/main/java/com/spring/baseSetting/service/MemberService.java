package com.spring.baseSetting.service;

import com.spring.baseSetting.dto.Member;

import java.util.List;

public interface MemberService {
    List<Member> getAllMemberList();
    Member getMember(String id);
    int addMember(Member member);
}
