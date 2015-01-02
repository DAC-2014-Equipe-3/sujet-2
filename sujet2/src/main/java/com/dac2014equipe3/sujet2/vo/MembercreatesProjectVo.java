package com.dac2014equipe3.sujet2.vo;

import com.dac2014equipe3.sujet2.model.entity.Member;
import com.dac2014equipe3.sujet2.model.entity.MembercreatesProjectPK;
import com.dac2014equipe3.sujet2.model.entity.Project;


/**
 * Created by guilherme on 01/01/15.
 */
public class MembercreatesProjectVo implements IValueObject {

    protected MembercreatesProjectPK membercreatesProjectPK;
    private MemberVo member1;
    private ProjectVo project;

    public MembercreatesProjectVo(MembercreatesProjectPK membercreatesProjectPK, MemberVo member1, ProjectVo project) {
        this.membercreatesProjectPK = membercreatesProjectPK;
        this.member1 = member1;
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

    public MemberVo getMember1() {
        return member1;
    }

    public void setMember1(MemberVo member1) {
        this.member1 = member1;
    }
}
