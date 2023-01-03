package day01.model.vo;

import java.sql.Date;

public class Student {
    private String studentId, studentPwd, studentName, email, address, hobby;
    private String gender;
    private int age, phone;
    private Date enrollDate;

    public Student(String studentId, String studentPwd, String studentName, String email, String address, String hobby, String gender, int age, int phone) {
        this.studentId = studentId;
        this.studentPwd = studentPwd;
        this.studentName = studentName;
        this.email = email;
        this.address = address;
        this.hobby = hobby;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
    }

    public Student(String studentPwd, String studentName, String email, String address, String hobby, String gender, int age, int phone) {
        this.studentPwd = studentPwd;
        this.studentName = studentName;
        this.email = email;
        this.address = address;
        this.hobby = hobby;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
    }

    public Student() {
    }


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentPwd() {
        return studentPwd;
    }

    public void setStudentPwd(String studentPwd) {
        this.studentPwd = studentPwd;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }


    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentPwd='" + studentPwd + '\'' +
                ", studentName='" + studentName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", hobby='" + hobby + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                ", enrollDate=" + enrollDate +
                '}';
    }
}
