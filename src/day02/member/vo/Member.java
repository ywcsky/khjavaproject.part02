package day02.member.vo;

public class Member {
    private String memberId, memberPwd,memberName,memberGender,memberEmail,memberPhone,memberAddress,memberHobby,memberDate;
    private int memberAge;

    public Member(String memberId, String memberPwd, String memberName, String memberGender) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.memberGender = memberGender;
    }

    public Member(String memberPwd, String memberName, String memberGender, String memberEmail, String memberPhone, String memberAddress, String memberHobby, int memberAge) {
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.memberGender = memberGender;
        this.memberEmail = memberEmail;
        this.memberPhone = memberPhone;
        this.memberAddress = memberAddress;
        this.memberHobby = memberHobby;
        this.memberAge = memberAge;
    }

    public Member(String memberId, String memberPwd, String memberName, String memberGender,
                  String memberEmail, String memberPhone, String memberAddress, String memberHobby, int memberAge) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.memberGender = memberGender;
        this.memberEmail = memberEmail;
        this.memberPhone = memberPhone;
        this.memberAddress = memberAddress;
        this.memberHobby = memberHobby;
        this.memberAge = memberAge;
    }

    public Member() {
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPwd() {
        return memberPwd;
    }

    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberGender() {
        return memberGender;
    }

    public void setMemberGender(String memberGender) {
        this.memberGender = memberGender;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public String getMemberHobby() {
        return memberHobby;
    }

    public void setMemberHobby(String memberHobby) {
        this.memberHobby = memberHobby;
    }

    public String getMemberDate() {
        return memberDate;
    }

    public void setMemberDate(String memberDate) {
        this.memberDate = memberDate;
    }

    public int getMemberAge() {
        return memberAge;
    }

    public void setMemberAge(int memberAge) {
        this.memberAge = memberAge;
    }
}
