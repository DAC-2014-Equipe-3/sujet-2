package com.dac2014equipe3.sujet2.vo;

import com.dac2014equipe3.sujet2.model.entity.MembercreatesProjectPK;


/**
 * Created by guilherme on 01/01/15.
 */
public class MembercreatesProjectVo implements IValueObject {

    protected MembercreatesProjectPK membercreatesProjectPK;
    private MemberVo member;
    private ProjectVo project;

    public MembercreatesProjectVo(MembercreatesProjectPK membercreatesProjectPK, MemberVo member, ProjectVo project) {
        this.membercreatesProjectPK = membercreatesProjectPK;
        this.member = member;
        this.project = project;
    }

    public ProjectVo getProject() {
        return project;
    }

    public void setProject(ProjectVo project) {
        this.project = project;
    }

    public MembercreatesProjectPK getMembercreatesProjectPK() {
        return membercreatesProjectPK;
    }

    public void setMembercreatesProjectPK(MembercreatesProjectPK membercreatesProjectPK) {
        this.membercreatesProjectPK = membercreatesProjectPK;
    }

    public MemberVo getMember() {
        return member;
    }

    public void setMember(MemberVo member) {
        this.member = member;
    }
}
