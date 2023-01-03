package day03.member.run;

import day03.member.controller.MemberController;
import day03.member.model.vo.Member;
import day03.member.view.MemberView;

import java.util.List;

public class MemberRun {
    public static void main(String[] args) {
        MemberView mView = new MemberView();
        MemberController mCon = new MemberController();
        String memberId = "";
        Member member;
        end:
        while (true){
            int choice = mView.mainMenu();
            switch (choice){
                case 0 : break end;
                case 1 :
                    mView.showAll(mCon.printAll(),"전체 회원 조회");
                    break;
                case 2 :
                    member = mCon.printOneBy(mView.inputDataSearch("조회할 아이디"),1);
                    mView.showCondition(member,"아이디로 조회");
                    break;
                case 3 :
                    List<Member> mList = mCon.printAllByName(mView.inputDataSearch("조회할 이름"));
                    mView.showAll(mList,"이름으로 조회");
                    break;
                case 4 :
                   int result = mCon.registerMember(mView.inputMember());
                   if(result > 0){
                       mView.printMsg("회원가입 성공!");
                   } else {
                       mView.printMsg("회원가입 실패 ㅠㅠ");
                   }
                    break;
                case 5 :
                    memberId = mView.inputDataSearch("수정할 아이디");
                    member = mCon.printOneBy(memberId,1);
                    if(member != null){
                        member = mView.modifyMember(memberId);
                        result = mCon.modifyMember(member);
                        if(result > 0){
                            mView.printMsg("정보 수정 성공!");
                        } else {
                            mView.printMsg("정보 수정 실패 ㅠㅠ");
                        }
                    }else {
                        mView.printMsg("존재하지 않는 회원입니다.");
                    }
                    break;
                case 6 :
                    result = mCon.removeMember(mView.inputDataSearch("삭제할 아이디"));
                    if(result > 0){
                        mView.printMsg("삭제 완료!");
                    } else {
                        mView.printMsg("삭제 실패 ㅠㅠ");
                    }
                    break;
            }
        }
    }
}
