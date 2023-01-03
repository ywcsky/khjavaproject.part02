package day02.member.controller;


import day02.member.dao.MemberDAO;
import day02.member.vo.Member;

import java.util.List;

public class MemberController {

    public List<Member> printAll(){
        MemberDAO mdao = new MemberDAO();
        return mdao.printAll();
    }

    public Member printCondition(int index, String param){
        MemberDAO mdao = new MemberDAO();
        return mdao.searchTo(index,param);
    }

    public int insertMember(Member member){
        MemberDAO dao = new MemberDAO();
        return dao.insertMember(member);
    }

    public int deleteMember(String str){
        MemberDAO dao = new MemberDAO();
        return dao.deleteMember(str);
    }
    public int updateMember(Member member,String id){
        MemberDAO dao = new MemberDAO();
        return dao.updateMember(member,id);
    }
}
