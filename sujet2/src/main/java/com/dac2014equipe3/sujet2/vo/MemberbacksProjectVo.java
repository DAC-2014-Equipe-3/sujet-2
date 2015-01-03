package com.dac2014equipe3.sujet2.vo;


import com.dac2014equipe3.sujet2.model.entity.Member;
import com.dac2014equipe3.sujet2.model.entity.MemberbacksProjectPK;
import com.dac2014equipe3.sujet2.model.entity.Project;
import com.dac2014equipe3.sujet2.model.entity.Reward;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Monssef on 03/01/15.
 */
public class MemberbacksProjectVo implements IValueObject{

    protected MemberbacksProjectPK memberbacksProjectPK;
    private int pledgedEuros;
    private Date backingDate;
    private MemberVo member1;
    private ProjectVo project;
    private Reward reward;

    public MemberbacksProjectVo(MemberbacksProjectPK memberbacksProjectPK, int pledgedEuros, Date backingDate, MemberVo member1, ProjectVo project, Reward reward) {
        this.memberbacksProjectPK = memberbacksProjectPK;
        this.pledgedEuros = pledgedEuros;
        this.backingDate = backingDate;
        this.member1 = member1;
        this.project = project;
        this.reward = reward;
    }

    public MemberbacksProjectPK getMemberbacksProjectPK() {
        return memberbacksProjectPK;
    }

    public void setMemberbacksProjectPK(MemberbacksProjectPK memberbacksProjectPK) {
        this.memberbacksProjectPK = memberbacksProjectPK;
    }

    public int getPledgedEuros() {
        return pledgedEuros;
    }

    public void setPledgedEuros(int pledgedEuros) {
        this.pledgedEuros = pledgedEuros;
    }

    public Date getBackingDate() {
        return backingDate;
    }

    public void setBackingDate(Date backingDate) {
        this.backingDate = backingDate;
    }

    public MemberVo getMember1() {
        return member1;
    }

    public void setMember1(MemberVo member1) {
        this.member1 = member1;
    }

    public ProjectVo getProject() {
        return project;
    }

    public void setProject(ProjectVo project) {
        this.project = project;
    }

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }
}
