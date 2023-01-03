package day01.run;


import day01.controller.StudentController;
import day01.model.vo.Student;
import day01.view.StudentView;

import java.util.List;

public class StudentRun {
    public static void main(String[] args) {
        StudentController sCon = new StudentController();
        StudentView sView = new StudentView();
        List<Student> sList;

        done:
        while (true) {
            switch (sView.menu()) {
                case 1:
                    sList = sCon.printAll();
                    if (!sList.isEmpty()) {
                        sView.showAll(sList);
                    } else {
                        sView.printMessage("일치하는 데이터가 없습니다.");
                    }
                    break;
                case 2:
                    sList = sCon.selectSearch(sView.search("아이디"), 1);
                    if (!sList.isEmpty()) {
                        sView.printSearch(sList, "아이디");
                    } else {
                        sView.printMessage("일치하는 데이터가 없습니다.");
                    }
                    break;
                case 3:
                    sList = sCon.selectSearch(sView.search("이름"), 2);
                    if (!sList.isEmpty()) {
                        sView.printSearch(sList, "이름");
                    } else {
                        sView.printMessage("일치하는 데이터가 없습니다.");
                    }
                    break;
                case 4:
                    Student student = sView.inputStudent();
                    int result = sCon.registerMember(student);
                    if (result > 0) {
                        sView.success(result, "가입이 완료되었습니다.");
                    } else {
                        sView.success(result, "가입에 실패하였습니다. ");
                    }
                    break;
                case 5:
                    result = sCon.deleteMember(sView.deleteMember());
                    if (result > 0) {
                        sView.success(result, "탈퇴가 완료되었습니다.");
                    } else {
                        sView.success(result, "탈퇴에 실패하였습니다. \n 아이디를 다시 확인하세요.");
                    }
                    break;
                case 6:
                    String id = sView.findStudent("수정할 아이디");
                    if(id != null){

                    }
                    result = sCon.modifyStudent(id, sView.modifyStudent());
                    System.out.println(result + "개의 값이 변경되었습니다.");
                    break;
                case 0:
                    break done;
                default:
                    sView.printMessage("잘못입력하셨습니다. 1 ~ 6 사이의 수를 입력하세요.");
                    break;
            }
        }


//
    }
}
