package com.spring.baseSetting.dao.impl;

import com.spring.baseSetting.dao.MemberDao;
import com.spring.baseSetting.dto.Member;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //마이바티스 mapper xml에서 설정한 mapper 이름
    private final String MAPPER = "mapper.member.";

    private final SqlSession sqlSession;
    public MemberDaoImpl(SqlSession sqlSession) {
        logger.info("MemberDaoImpl Init...");
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Member> selectAllMember() {
        List<Member> members = sqlSession.selectList(MAPPER + "selectAllMember");
        return members;
    }

    @Override
    public Member selectMemberById(String id) {
        Member member = sqlSession.selectOne(MAPPER + "selectMemberById", id);
        return member;
    }

    @Override
    public int insertMember(Member member) {
        int result = sqlSession.insert(MAPPER + "insertMember", member);
        return result;
    }
}
