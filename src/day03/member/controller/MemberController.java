package day03.member.controller;

import day03.member.model.vo.Member;
import day03.member.service.MemberService;

import java.util.List;

public class MemberController {

    private MemberService mService;

    public MemberController() {          // 없으면 Null PointException 의 원인
        mService = new MemberService();
    }

    public List<Member> printAll() {
        List<Member> mList = mService.selectAll();
        return mList;
    }


    public int registerMember(Member member) {
        return mService.insertMember(member);
    }

    public int removeMember(String id) {
        return mService.deleteMember(id);
    }

    public int modifyMember(Member member) {
        return mService.updateMember(member);
    }

        public List<Member> printAllByName(String memberName) {
        List<Member> mList = mService.selectAllByName(memberName);
        return mList;
    }
    public Member printOneBy(String input) {
        Member member = mService.selectOneBy(input);
        return member;
    }
}
