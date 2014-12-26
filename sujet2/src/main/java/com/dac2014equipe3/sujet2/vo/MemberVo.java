package com.dac2014equipe3.sujet2.vo;
import java.util.Date;
import java.util.List;

public class MemberVo implements IValueObject {

    private Integer memberId;
    private String memberEmail;
    private String memberLogin;
    private String memberPassword;
    private Boolean memberIsAdmin;
    private Date memberJoiningDate;
    private String memberLastname;
    private String memberFirstname;
    private Date memberBirthday;
    private String memberNationality;
    private String memberSex;
    private String memberProfession;
    private Boolean memberIsSuppressed;
    private List<ProjectVo> projectList;
    private List<MemberbacksProjectVo> memberbacksProjectList;

    /**
     * @return the memberId
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * @return the memberEmail
     */
    public String getMemberEmail() {
        return memberEmail;
    }

    /**
     * @return the memberLogin
     */
    public String getMemberLogin() {
        return memberLogin;
    }

    /**
     * @return the memberPassword
     */
    public String getMemberPassword() {
        return memberPassword;
    }

    /**
     * @return the memberIsAdmin
     */
    public Boolean getMemberIsAdmin() {
        return memberIsAdmin;
    }

    /**
     * @return the memberJoiningDate
     */
    public Date getMemberJoiningDate() {
        return memberJoiningDate;
    }

    /**
     * @return the memberLastname
     */
    public String getMemberLastname() {
        return memberLastname;
    }

    /**
     * @return the memberFirstname
     */
    public String getMemberFirstname() {
        return memberFirstname;
    }

    /**
     * @return the memberBirthday
     */
    public Date getMemberBirthday() {
        return memberBirthday;
    }

    /**
     * @return the memberNationality
     */
    public String getMemberNationality() {
        return memberNationality;
    }

    /**
     * @return the memberSex
     */
    public String getMemberSex() {
        return memberSex;
    }

    /**
     * @return the memberProfession
     */
    public String getMemberProfession() {
        return memberProfession;
    }

    /**
     * @return the memberIsSuppressed
     */
    public Boolean getMemberIsSuppressed() {
        return memberIsSuppressed;
    }

    /**
     * @return the projectList
     */
    public List<ProjectVo> getProjectList() {
        return projectList;
    }

    /**
     * @return the memberbacksProjectList
     */
    public List<MemberbacksProjectVo> getMemberbacksProjectList() {
        return memberbacksProjectList;
    }

    /**
     * @param memberId the memberId to set
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * @param memberEmail the memberEmail to set
     */
    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    /**
     * @param memberLogin the memberLogin to set
     */
    public void setMemberLogin(String memberLogin) {
        this.memberLogin = memberLogin;
    }

    /**
     * @param memberPassword the memberPassword to set
     */
    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    /**
     * @param memberIsAdmin the memberIsAdmin to set
     */
    public void setMemberIsAdmin(Boolean memberIsAdmin) {
        this.memberIsAdmin = memberIsAdmin;
    }

    /**
     * @param memberJoiningDate the memberJoiningDate to set
     */
    public void setMemberJoiningDate(Date memberJoiningDate) {
        this.memberJoiningDate = memberJoiningDate;
    }

    /**
     * @param memberLastname the memberLastname to set
     */
    public void setMemberLastname(String memberLastname) {
        this.memberLastname = memberLastname;
    }

    /**
     * @param memberFirstname the memberFirstname to set
     */
    public void setMemberFirstname(String memberFirstname) {
        this.memberFirstname = memberFirstname;
    }

    /**
     * @param memberBirthday the memberBirthday to set
     */
    public void setMemberBirthday(Date memberBirthday) {
        this.memberBirthday = memberBirthday;
    }

    /**
     * @param memberNationality the memberNationality to set
     */
    public void setMemberNationality(String memberNationality) {
        this.memberNationality = memberNationality;
    }

    /**
     * @param memberSex the memberSex to set
     */
    public void setMemberSex(String memberSex) {
        this.memberSex = memberSex;
    }

    /**
     * @param memberProfession the memberProfession to set
     */
    public void setMemberProfession(String memberProfession) {
        this.memberProfession = memberProfession;
    }

    /**
     * @param memberIsSuppressed the memberIsSuppressed to set
     */
    public void setMemberIsSuppressed(Boolean memberIsSuppressed) {
        this.memberIsSuppressed = memberIsSuppressed;
    }

    /**
     * @param projectList the projectList to set
     */
    public void setProjectList(List<ProjectVo> projectList) {
        this.projectList = projectList;
    }

    /**
     * @param memberbacksProjectList the memberbacksProjectList to set
     */
    public void setMemberbacksProjectList(List<MemberbacksProjectVo> memberbacksProjectList) {
        this.memberbacksProjectList = memberbacksProjectList;
    }
    
    
}
