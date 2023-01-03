package day01.view;

import day01.model.vo.Student;

import java.util.List;
import java.util.Scanner;

public class StudentView {
    Scanner sc = new Scanner(System.in);

    public void printMessage(String msg) {
        System.out.println(msg);
    }

    public int menu() {
        System.out.println("=== === 학생관리 === ===");
        System.out.println("1. 전체 정보 조회");
        System.out.println("2. 아이디로 정보 조회");
        System.out.println("3. 이름으로 정보 조회");
        System.out.println("4. 가입");
        System.out.println("5. 회원탈퇴");
        System.out.println("6. 정보 수정");
        System.out.print("선택 : ");
        return sc.nextInt();
    }

    public void showAll(List<Student> students) {
        System.out.println("=== === 학생 전체 정보 조회 === ===");
        for (Student sOne : students) {
            System.out.print("아이디 : " + sOne.getStudentId());
            System.out.print(", 비밀번호 : " + sOne.getStudentPwd());
            System.out.print(", 이름 : " + sOne.getStudentName());
            System.out.print(", 성별 : " + sOne.getGender());
            System.out.print(", 나이 : " + sOne.getAge());
            System.out.print(", 주소 : " + sOne.getEmail());
            System.out.print(", 연락처 : " + sOne.getPhone());
            System.out.print(", 주소 : " + sOne.getAddress());
            System.out.print(", 취미 : " + sOne.getHobby());
            System.out.println(", 가입일 : " + sOne.getEnrollDate());
        }
    }

    public Student inputStudent() {
        System.out.print("아이디 : ");
        String studentId = sc.next();
        System.out.print("비밀번호 : ");
        String studentPwd = sc.next();
        System.out.print("이름 : ");
        String studentName = sc.next();
        System.out.print("성별 : ");
        String gender = sc.next();
        System.out.print("나이 : ");
        int age = sc.nextInt();
        System.out.print("이메일 : ");
        String email = sc.next();
        System.out.print("주소 : ");
        sc.nextLine();
        String studentAddress = sc.nextLine();
        System.out.print("전화번호 : ");
        int phone = sc.nextInt();
        System.out.print("취미(,로 구분) : ");
        String hobby = sc.next();
        return new Student(studentId, studentPwd, studentName, email, studentAddress, hobby, gender, age, phone);
    }

    public void success(int result, String msg) {
        if (result > 0) {
            System.out.println("[서비스 성공] : " + msg);
        } else {
            System.out.println("[서비스 실패] : " + msg);
        }
    }

    public String deleteMember() {
        System.out.print("삭제 할 아이디 입력 : ");
        return sc.next();
    }

    public String search(String para){
        System.out.println("검색 할 "+para+" 입력 : ");
        return sc.next();
    }

    public void printSearch(List<Student> students, String msg) {
        System.out.println("=== === 학생 "+msg+"으로 정보 조회 === ===");
        for (Student sTwo : students) {
            System.out.print("아이디 : " + sTwo.getStudentId());
            System.out.print(", 비밀번호 : " + sTwo.getStudentPwd());
            System.out.print(", 이름 : " + sTwo.getStudentName());
            System.out.print(", 성별 : " + sTwo.getGender());
            System.out.print(", 나이 : " + sTwo.getAge());
            System.out.print(", 이메일 : " + sTwo.getEmail());
            System.out.print(", 연락처 : " + sTwo.getPhone());
            System.out.print(", 주소 : " + sTwo.getAddress());
            System.out.print(", 취미 : " + sTwo.getHobby());
            System.out.println(", 가입일 : " + sTwo.getEnrollDate());
        }
    }

    public String findStudent(String msg){
        System.out.print(msg+" 입력 : ");
        return sc.next();
    }

    public Student modifyStudent(){
        System.out.print("1. 비밀번호 : ");
        String pwd = sc.next();
        System.out.print("2. 이름 : ");
        String name = sc.next();
        System.out.print("3. 성별 : ");
        String gender = sc.next();
        System.out.print("4. 나이 : ");
        int age = sc.nextInt();
        System.out.print("5. 연락처 : ");
        int phone = sc.nextInt();
        System.out.print("6. 이메일 : ");
        String email = sc.next();
        System.out.print("7. 주소 : ");
        sc.nextLine();
        String address = sc.nextLine();
        System.out.print("8. 취미 : ");
        String hobby = sc.next();
        return new Student(pwd,name,email,address,hobby,gender,age,phone);
    }

}
