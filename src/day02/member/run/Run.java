package day02.member.run;

import day02.member.controller.MemberController;
import day02.member.view.MemberView;

public class Run {
    public static void main(String[] args) {
        MemberView mView = new MemberView();
        MemberController mCon = new MemberController();
        end:
        while(true){
            switch (mView.mainMenu()){
                case 1:
                    mView.showAll(mCon.printAll());
                    break;
                case 2:
                    mView.showCondition(mCon.printCondition(1,mView.searchInput("검색할 아이디")),"회원 아이디로 검색");
                    break;
                case 3:
                    mView.showCondition(mCon.printCondition(2,mView.searchInput("검색할 이름")),"회원 이름으로 검색");
                    break;
                case 4:
                    int rset = mCon.insertMember(mView.insertMember());
                    if(rset > 0){
                        mView.printMsg("회원가입 성공!");
                    }
                    break;
                case 5:
                    String id = mView.searchInput("수정할 아이디");
                    rset = mCon.updateMember(mView.updateMember(),id);
                    if(rset > 0){
                        mView.printMsg("업데이트 성공!");
                    }else {
                        mView.printMsg("업데이트 실패 ㅠㅠ");
                    }
                    break;
                case 6:
                    rset = mCon.deleteMember(mView.searchInput("삭제할 아이디"));
                    if(rset > 0){
                        mView.printMsg("회원 삭제 성공!");
                    } else {
                        mView.printMsg("회원 삭제 실패");
                    }
                    break;
                case 0:break end;
            }
        }
    }
}
