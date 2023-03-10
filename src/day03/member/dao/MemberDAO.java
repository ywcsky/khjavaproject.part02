package day03.member.dao;

import day03.member.model.vo.Member;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MemberDAO{
    private Properties prop;

    public MemberDAO() {
        prop = new Properties();
        try {
            FileReader fr = new FileReader("src/resources/query.properties");
            prop.load(fr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Member> selectAll(Connection conn) {    // 회원 전체 정보 조회
        List<Member> mList = new ArrayList<>();
        String sql = prop.getProperty("selectAll");

        try {
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(sql);
            while (rset.next()) {
               Member member = new Member();
                member.setMemberId(rset.getString("MEMBER_ID"));
                member.setMemberPwd(rset.getString("MEMBER_PWD"));
                member.setMemberName(rset.getString("MEMBER_NAME"));
                member.setMemberGender(rset.getString("MEMBER_GENDER"));
                member.setMemberAge(rset.getInt("MEMBER_AGE"));
                member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
                member.setMemberPhone(rset.getString("MEMBER_PHONE"));
                member.setMemberAddress(rset.getString("MEMBER_ADDRESS"));
                member.setMemberHobby(rset.getString("MEMBER_HOBBY"));
                member.setMemberDate(rset.getString("MEMBER_DATE"));
                mList.add(member);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return mList;
    }
    public Member selectOneById(Connection conn, String input) {
        String sql = prop.getProperty("selectOneById");

        Member member = new Member();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, input);
            ResultSet rset = pstmt.executeQuery();
            if(rset.next()){
                member.setMemberId(rset.getString("MEMBER_ID"));
                member.setMemberPwd(rset.getString("MEMBER_PWD"));
                member.setMemberName(rset.getString("MEMBER_NAME"));
                member.setMemberGender(rset.getString("MEMBER_GENDER"));
                member.setMemberAge(rset.getInt("MEMBER_AGE"));
                member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
                member.setMemberPhone(rset.getString("MEMBER_PHONE"));
                member.setMemberAddress(rset.getString("MEMBER_ADDRESS"));
                member.setMemberHobby(rset.getString("MEMBER_HOBBY"));
                member.setMemberDate(rset.getString("MEMBER_DATE"));
            }
            rset.close();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return member;
    }

    public List<Member> selectAllByName(Connection conn, String memberName) {
        String sql = prop.getProperty("selectAllByName");
        List<Member> mList = new ArrayList<>();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+memberName+"%");
            ResultSet rset = pstmt.executeQuery();
            while(rset.next()){
                Member member = new Member();
                member.setMemberId(rset.getString("MEMBER_ID"));
                member.setMemberPwd(rset.getString("MEMBER_PWD"));
                member.setMemberName(rset.getString("MEMBER_NAME"));
                member.setMemberGender(rset.getString("MEMBER_GENDER"));
                member.setMemberAge(rset.getInt("MEMBER_AGE"));
                member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
                member.setMemberPhone(rset.getString("MEMBER_PHONE"));
                member.setMemberAddress(rset.getString("MEMBER_ADDRESS"));
                member.setMemberHobby(rset.getString("MEMBER_HOBBY"));
                member.setMemberDate(rset.getString("MEMBER_DATE"));
                mList.add(member);
            }
            rset.close();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return mList;
    }
    public int insertMember(Connection conn, Member member){
        String sql = prop.getProperty("insertMember");
        int result = 0;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,member.getMemberId());
            pstmt.setString(2,member.getMemberPwd());
            pstmt.setString(3, member.getMemberName());
            pstmt.setString(4, member.getMemberGender());
            pstmt.setInt(5, member.getMemberAge());
            pstmt.setString(6, member.getMemberEmail());
            pstmt.setString(7, member.getMemberPhone());
            pstmt.setString(8, member.getMemberAddress());
            pstmt.setString(9, member.getMemberHobby());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int deleteMember(Connection conn,String memberId){
        String sql = prop.getProperty("deleteMember");
        int result;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memberId);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int updateMember(Connection conn, Member member){
        String sql = prop.getProperty("updateMember");
        int result = 0;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getMemberPwd());
            pstmt.setString(2, member.getMemberName());
            pstmt.setString(3, member.getMemberGender());
            pstmt.setInt(4, member.getMemberAge());
            pstmt.setString(5, member.getMemberEmail());
            pstmt.setString(6, member.getMemberPhone());
            pstmt.setString(7, member.getMemberAddress());
            pstmt.setString(8, member.getMemberHobby());
            result = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}

