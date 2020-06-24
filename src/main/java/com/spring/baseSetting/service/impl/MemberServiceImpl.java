package com.spring.baseSetting.service.impl;

import com.spring.baseSetting.dao.MemberDao;
import com.spring.baseSetting.dto.Member;
import com.spring.baseSetting.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final MemberDao memberDao;

    public MemberServiceImpl(MemberDao memberDao) {
        logger.info("MemberServiceImpl Init...");
        this.memberDao = memberDao;
    }

    @Override
    public List<Member> getAllMemberList() {
        List<Member> members = memberDao.selectAllMember();
        return members;
    }

    @Override
    public Member getMember(String id) {
        Member member = memberDao.selectMemberById(id);
        return member;
    }

    @Override
    public int addMember(Member member) {
        int result = memberDao.insertMember(member);
        return result;
    }
}
