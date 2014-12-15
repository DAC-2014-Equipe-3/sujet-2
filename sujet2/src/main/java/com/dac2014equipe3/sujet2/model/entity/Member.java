/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dac2014equipe3.sujet2.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 *
 * @author Jummartinezro
 */
@Entity
public class Member implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = IDENTITY)
    private Integer memberId;
    private String memberEmail;
    private String memberPassword;
    private Date memberJoiningDate;
    private String memberName;
    private String memberSurname;
    private Date memberBirthday;
    private String memberNationality;
    @ElementCollection
    private List<Project> projectList;
    @ElementCollection
    private List<MemberbacksProject> memberbacksProjectList;

    public Member() {
    }

    public Member(Integer memberId) {
        this.memberId = memberId;
    }

    public Member(Integer memberId, String memberEmail, String memberPassword, Date memberJoiningDate, String memberName, String memberSurname, Date memberBirthday, String memberNationality) {
        this.memberId = memberId;
        this.memberEmail = memberEmail;
        this.memberPassword = memberPassword;
        this.memberJoiningDate = memberJoiningDate;
        this.memberName = memberName;
        this.memberSurname = memberSurname;
        this.memberBirthday = memberBirthday;
        this.memberNationality = memberNationality;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public Date getMemberJoiningDate() {
        return memberJoiningDate;
    }

    public void setMemberJoiningDate(Date memberJoiningDate) {
        this.memberJoiningDate = memberJoiningDate;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberSurname() {
        return memberSurname;
    }

    public void setMemberSurname(String memberSurname) {
        this.memberSurname = memberSurname;
    }

    public Date getMemberBirthday() {
        return memberBirthday;
    }

    public void setMemberBirthday(Date memberBirthday) {
        this.memberBirthday = memberBirthday;
    }

    public String getMemberNationality() {
        return memberNationality;
    }

    public void setMemberNationality(String memberNationality) {
        this.memberNationality = memberNationality;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public List<MemberbacksProject> getMemberbacksProjectList() {
        return memberbacksProjectList;
    }

    public void setMemberbacksProjectList(List<MemberbacksProject> memberbacksProjectList) {
        this.memberbacksProjectList = memberbacksProjectList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memberId != null ? memberId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Member)) {
            return false;
        }
        Member other = (Member) object;
        if ((this.memberId == null && other.memberId != null) || (this.memberId != null && !this.memberId.equals(other.memberId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dac2014equipe3.sujet2.model.entity.Member[ memberId=" + memberId + " ]";
    }

}
