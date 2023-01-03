package day02.member.dao;


import day02.member.vo.Member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    List<Member> mList = new ArrayList<>();

    private String oracle = "oracle.jdbc.driver.OracleDriver", url = "jdbc:oracle:thin:@localhost:1521:xe", user = "STUDENT", pass = "STUDENT";
    String sql = "SELECT * FROM MEMBER_TBL";

    public List<Member> printAll(){
        try {
            Class.forName(oracle);
            Connection conn = DriverManager.getConnection(url,user,pass);
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(sql);
            while(rset.next()){
                Member m = new Member();
                m.setMemberId(rset.getString("MEMBER_ID"));
                m.setMemberPwd(rset.getString("MEMBER_PWD"));
                m.setMemberName(rset.getString("MEMBER_NAME"));
                m.setMemberGender(rset.getString("MEMBER_GENDER"));
                m.setMemberAge(rset.getInt("MEMBER_AGE"));
                m.setMemberEmail(rset.getString("MEMBER_EMAIL"));
                m.setMemberPhone(rset.getString("MEMBER_PHONE"));
                m.setMemberAddress(rset.getString("MEMBER_ADDRESS"));
                m.setMemberHobby(rset.getString("MEMBER_HOBBY"));
                m.setMemberDate(rset.getString("MEMBER_DATE"));
                mList.add(m);
            }
            return mList;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Member searchTo(int index, String param){
        String index2 = "";
        String sql = "";
        if(index == 1){
            sql = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = '" + param +"'" ;
        } else if(index == 2){
            sql = "SELECT * FROM MEMBER_TBL WHERE MEMBER_NAME like '%" +param+"%'";
        }
        try {
            Class.forName(oracle);
            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rset = stmt.executeQuery();
            Member m = new Member();
            while(rset.next()) {
                m.setMemberId(rset.getString("MEMBER_ID"));
                m.setMemberPwd(rset.getString("MEMBER_PWD"));
                m.setMemberName(rset.getString("MEMBER_NAME"));
                m.setMemberGender(rset.getString("MEMBER_GENDER"));
                m.setMemberAge(rset.getInt("MEMBER_AGE"));
                m.setMemberEmail(rset.getString("MEMBER_EMAIL"));
                m.setMemberPhone(rset.getString("MEMBER_PHONE"));
                m.setMemberAddress(rset.getString("MEMBER_ADDRESS"));
                m.setMemberHobby(rset.getString("MEMBER_HOBBY"));
                m.setMemberDate(rset.getString("MEMBER_DATE"));
            }
            return m;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int insertMember(Member member){
        String sql = "INSERT INTO MEMBER_TBL VALUES (?,?,?,?,?,?,?,?,?,DEFAULT)";
        try {
            Class.forName(oracle);
            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, member.getMemberId());
            stmt.setString(2, member.getMemberPwd());
            stmt.setString(3, member.getMemberName());
            stmt.setString(4, member.getMemberGender());
            stmt.setInt(5, member.getMemberAge());
            stmt.setString(6, member.getMemberEmail());
            stmt.setString(7, member.getMemberPhone());
            stmt.setString(8, member.getMemberAddress());
            stmt.setString(9, member.getMemberHobby());
            return stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int deleteMember(String id){
        String sql = "DELETE FROM MEMBER_TBL WHERE MEMBER_ID = '" +id+"'";
        try {
            Class.forName(oracle);
            Connection conn = DriverManager.getConnection(url, user,pass);
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public int updateMember(Member member, String id){
        String sql = "UPDATE MEMBER_TBL SET MEMBER_PWD = ?, MEMBER_NAME = ?, MEMBER_GENDER = ?, MEMBER_AGE = ?," +
                "MEMBER_EMAIL = ?, MEMBER_PHONE = ?, MEMBER_ADDRESS = ?, MEMBER_HOBBY = ? WHERE MEMBER_ID = '" +id+"'";
        try {
            Class.forName(oracle);
            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, member.getMemberPwd());
            stmt.setString(2, member.getMemberName());
            stmt.setString(3, member.getMemberGender());
            stmt.setInt(4, member.getMemberAge());
            stmt.setString(5, member.getMemberEmail());
            stmt.setString(6, member.getMemberPhone());
            stmt.setString(7, member.getMemberAddress());
            stmt.setString(8, member.getMemberHobby());
            return stmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
