package day01.dao;

import day01.model.vo.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    List<Student> sList = new ArrayList<>();
    private final String driver_name = "oracle.jdbc.driver.OracleDriver",url = "jdbc:oracle:thin:@localhost:1521:xe",user = "STUDENT", pwd = "STUDENT";

    public StudentDAO() {
    }


    public List<Student> selectAll() {
        Student student;
        String sql = "SELECT * FROM STUDENT_TBL";
        try {
            Class.forName(driver_name);
            Connection conn = DriverManager.getConnection(url, user, pwd);
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(sql);
            while (rset.next()) {
                student = new Student();
                student.setStudentId(rset.getString("STUDENT_ID"));
                student.setStudentPwd(rset.getString("STUDENT_PWD"));
                student.setStudentName(rset.getString("STUDENT_NAME"));
                student.setGender(rset.getString("GENDER"));
                student.setAge(rset.getInt("AGE"));
                student.setEmail(rset.getString("EMAIL"));
                student.setPhone(rset.getInt("PHONE"));
                student.setAddress(rset.getString("ADDRESS"));
                student.setHobby(rset.getString("HOBBY"));
                student.setEnrollDate(rset.getDate("ENROLL_DATE"));
                sList.add(student);
            }
            rset.close();
            stmt.close();
            conn.close();
            return sList;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int insertMember(Student student) {
        int result;
        String sql = "INSERT INTO STUDENT_TBL VALUES(?,?,?,?,?,?,?,?,?,SYSDATE)";

        try {
            Class.forName(driver_name);
            Connection conn = DriverManager.getConnection(url, user, pwd);
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, student.getStudentId());
            stmt.setString(2, student.getStudentPwd());
            stmt.setString(3, student.getStudentName());
            stmt.setString(4, student.getGender());
            stmt.setInt(5, student.getAge());
            stmt.setString(6, student.getEmail());
            stmt.setInt(7, student.getPhone());
            stmt.setString(8, student.getAddress());
            stmt.setString(9, student.getHobby());
            result = stmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int deleteMember(String id) {
        int result;
        String sql = "DELETE FROM STUDENT_TBL WHERE STUDENT_ID = '" + id + "'";
        try {
            Class.forName(driver_name);
            Connection conn = DriverManager.getConnection(url, user, pwd);
            Statement stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<Student> selectSearch(String target, int choice) {
        String para = "";
        if (choice == 1) {
            para = "STUDENT_ID";
        } else if (choice == 2) {
            para = "STUDENT_NAME";
        }
        String sql = "SELECT STUDENT_ID, STUDENT_PWD,STUDENT_NAME, GENDER, AGE, EMAIL,PHONE, ADDRESS,HOBBY,ENROLL_DATE FROM STUDENT_TBL WHERE " + para + " = '" + target + "'";
        try {
            Class.forName(driver_name);
            Connection conn = DriverManager.getConnection(url, user, pwd);
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rset = stmt.executeQuery();
            while (rset.next()) {
                Student student = new Student();
                student.setStudentId(rset.getString(1));
                student.setStudentPwd(rset.getString(2));
                student.setStudentName(rset.getString(3));
                student.setGender(rset.getString(4));
                student.setAge(rset.getInt(5));
                student.setEmail(rset.getString(6));
                student.setPhone(rset.getInt(7));
                student.setAddress(rset.getString(8));
                student.setHobby(rset.getString(9));
                student.setEnrollDate(rset.getDate(10));
                sList.add(student);
            }
            conn.close();
            stmt.close();
            rset.close();
            return sList;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int studentModify(String id, Student student) {
        String sql = "UPDATE STUDENT_TBL SET STUDENT_PWD = ?, STUDENT_NAME = ?, GENDER =?,AGE = ?," +
                "EMAIL =?, PHONE = ?, ADDRESS = ?, HOBBY = ? WHERE STUDENT_ID = '" + id + "' ";
        int result;
        try {
            Class.forName(driver_name);
            Connection conn = DriverManager.getConnection(url, user, pwd);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, student.getStudentPwd());
            pstmt.setString(2, student.getStudentName());
            pstmt.setString(3, student.getGender());
            pstmt.setInt(4, student.getAge());
            pstmt.setString(5, student.getEmail());
            pstmt.setInt(6, student.getPhone());
            pstmt.setString(7, student.getAddress());
            pstmt.setString(8, student.getHobby());
            result = pstmt.executeUpdate();

            conn.close();
            pstmt.close();


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
