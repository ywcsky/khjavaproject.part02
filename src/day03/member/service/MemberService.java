package day03.member.service;

import common.JDBCTemplate;
import day03.member.dao.MemberDAO;
import day03.member.model.vo.Member;

import java.sql.Connection;
import java.util.List;

public class MemberService {

    private JDBCTemplate jdbcTemplate;
    private MemberDAO mDao;

    public MemberService() {
        mDao = new MemberDAO();
    }


    public List<Member> selectAll(){
        List<Member> mList;
        MemberDAO mDao = new MemberDAO();
//        JDBCTemplate jdbcTemplate = JDBCTemplate.getDriverLoad();
        Connection conn = JDBCTemplate.getConnection();
        mList = mDao.selectAll(conn);
        JDBCTemplate.close(conn);
        return mList;
    }

    public Member selectOneBy(String input, int index) {
        Connection conn = JDBCTemplate.getConnection();
        Member member = mDao.selectOneById(conn, input,index);
        JDBCTemplate.close(conn);
        return member;
    }

    public List<Member> selectAllByName(String memberName) {
        Connection conn = JDBCTemplate.getConnection();
         List<Member> mList = mDao.selectAllByName(conn, memberName);
        JDBCTemplate.close(conn);
        return mList;
    }

    public int insertMember(Member member) {
//        JDBCTemplate jdbcTemplate = JDBCTemplate.getDriverLoad();
        Connection conn = JDBCTemplate.getConnection();
        int result = mDao.insertMember(conn, member);
        if (result > 0) {
            JDBCTemplate.commit(conn);
        } else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        return result;
    }

    public int updateMember(Member member){
        Connection conn = JDBCTemplate.getConnection();
        int result = mDao.updateMember(conn, member);
        if(result > 0){
            JDBCTemplate.commit(conn);
        }else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        return result;
    }

    public int deleteMember(String memberId){
        Connection conn = JDBCTemplate.getConnection();
        int result = mDao.deleteMember(conn, memberId);
        if (result > 0) {
            JDBCTemplate.commit(conn);
        } else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        return result;
    }
}
