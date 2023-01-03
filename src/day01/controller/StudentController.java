package day01.controller;


import day01.dao.StudentDAO;
import day01.model.vo.Student;

import java.util.List;

public class StudentController {
    public List<Student> printAll() {
        StudentDAO dao = new StudentDAO();
        return dao.selectAll();
    }

    public int registerMember(Student student) {
        StudentDAO sDao = new StudentDAO();
        return sDao.insertMember(student);
    }

    public int deleteMember(String id) {
        StudentDAO sDao = new StudentDAO();
        return sDao.deleteMember(id);
    }


    public List<Student> selectSearch(String name,int choice){
        StudentDAO dao = new StudentDAO();
        return dao.selectSearch(name, choice);
    }

    public int modifyStudent(String id,Student student){
        StudentDAO dao = new StudentDAO();
        return dao.studentModify(id,student);
    }


}
