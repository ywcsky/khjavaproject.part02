package day03.member.view;


import day03.member.model.vo.Member;

import java.util.List;
import java.util.Scanner;

public class MemberView {
    Scanner sc = new Scanner(System.in);

    public int mainMenu() {
        System.out.println("=== === === 회원관리 프로그램 === === ===");
        System.out.println("1. 회원 전체 조회");
        System.out.println("2. 회원 아이디로 조회");
        System.out.println("3. 회원 이름으로 조회");
        System.out.println("4. 회원 가입");
        System.out.println("5. 회원 정보 수정");
        System.out.println("6. 회원 탈퇴");
        System.out.println("0. 프로그램 종료");
        System.out.print("메뉴 선택 : ");
        return sc.nextInt();

    }

    public void showAll(List<Member> mList, String msg) {
        System.out.println("=== === === "+ msg+" === === ===");
        for (Member mOne : mList) {
            System.out.print("아이디 : " + mOne.getMemberId() + " | ");
            System.out.print("비밀번호 : " + mOne.getMemberPwd() + " | ");
            System.out.print("이름 : " + mOne.getMemberName() + " | ");
            System.out.print("성별 : " + mOne.getMemberGender() + " | ");
            System.out.print("나이 : " + mOne.getMemberAge() + " | ");
            System.out.print("이메일 : " + mOne.getMemberEmail() + " | ");
            System.out.print("연락처 : " + mOne.getMemberPhone() + " | ");
            System.out.print("주소 : " + mOne.getMemberAddress() + " | ");
            System.out.print("취미 : " + mOne.getMemberHobby() + " | ");
            System.out.println("가입날짜 : " + mOne.getMemberDate());
        }
    }

    public String inputDataSearch(String msg) {
        System.out.print(msg + " 입력 : ");
        return sc.next();
    }

    public void showCondition(Member member, String msg) {
        if(member.getMemberId() == null){
            System.out.println("일치하는 데이터가 없습니다.");
        } else {
            System.out.println("=== === === " + msg + " === === ===");
            System.out.print("아이디 : " + member.getMemberId() + " | ");
            System.out.print("비밀번호 : " + member.getMemberPwd() + " | ");
            System.out.print("이름 : " + member.getMemberName() + " | ");
            System.out.print("성별 : " + member.getMemberGender() + " | ");
            System.out.print("나이 : " + member.getMemberAge() + " | ");
            System.out.print("이메일 : " + member.getMemberEmail() + " | ");
            System.out.print("연락처 : " + member.getMemberPhone() + " | ");
            System.out.print("주소 : " + member.getMemberAddress() + " | ");
            System.out.print("취미 : " + member.getMemberHobby() + " | ");
            System.out.println("가입날짜 : " + member.getMemberDate());
        }
    }

    public Member inputMember() {
        System.out.println("=== === === 회원 가입 === === ===");
        System.out.print("1. 아이디 : ");
        String id = sc.next();
        System.out.print("2. 비밀번호 : ");
        String pwd = sc.next();
        System.out.print("3. 이름 : ");
        String name = sc.next();
        System.out.print("4. 성별 : ");
        String gender = sc.next();
        System.out.print("5. 나이 : ");
        int age = sc.nextInt();
        System.out.print("6. 이메일 : ");
        String email = sc.next();
        System.out.print("7. 연락처 : ");
        String phone = sc.next();
        System.out.print("8. 주소 : ");
        sc.nextLine();
        String address = sc.nextLine();
        System.out.print("9. 취미 : ");
        String hobby = sc.next();
        return new Member(id, pwd, name, gender, email, phone, address, hobby, age);
    }

    public void printMsg(String msg) {
        System.out.println("[서비스 메시지] : " + msg);
    }

    public Member modifyMember(String id) {
        System.out.print("비밀번호 : ");
        String pwd = sc.next();
        System.out.print("이름 : ");
        String name = sc.next();
        System.out.print("성별 : ");
        String gender = sc.next();
        System.out.print("나이 : ");
        int age = sc.nextInt();
        System.out.print("이메일 : ");
        String email = sc.next();
        System.out.print("연락처 : ");
        String phone = sc.next();
        System.out.print("주소 : ");
        sc.nextLine();
        String address = sc.nextLine();
        System.out.print("취미 : ");
        String hobby = sc.next();
        return new Member(id,pwd, name, gender, email, phone, address, hobby, age);
    }

}
