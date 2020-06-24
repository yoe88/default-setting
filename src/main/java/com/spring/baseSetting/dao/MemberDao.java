package com.spring.baseSetting.dao;

import com.spring.baseSetting.dto.Member;

import java.util.List;

public interface MemberDao {
    List<Member> selectAllMember();
    Member selectMemberById(String id);
    int insertMember(Member member);
}
