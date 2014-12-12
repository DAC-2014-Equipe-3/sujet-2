/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dac2014equipe3.sujet2.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Jummartinezro
 */
public class MemberbacksProject implements Serializable {
    private static final long serialVersionUID = 1L;
    protected MemberbacksProjectPK memberbacksProjectPK;
    private int pledgedEuros;
    private Date backingDate;
    private Member member1;
    private Project project;
    private Reward reward;

    public MemberbacksProject() {
    }

    public MemberbacksProject(MemberbacksProjectPK memberbacksProjectPK) {
        this.memberbacksProjectPK = memberbacksProjectPK;
    }

    public MemberbacksProject(MemberbacksProjectPK memberbacksProjectPK, int pledgedEuros, Date backingDate) {
        this.memberbacksProjectPK = memberbacksProjectPK;
        this.pledgedEuros = pledgedEuros;
        this.backingDate = backingDate;
    }

    public MemberbacksProject(int backerId, int projectId, int rewardrewardId) {
        this.memberbacksProjectPK = new MemberbacksProjectPK(backerId, projectId, rewardrewardId);
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

    public Member getMember1() {
        return member1;
    }

    public void setMember1(Member member1) {
        this.member1 = member1;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memberbacksProjectPK != null ? memberbacksProjectPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MemberbacksProject)) {
            return false;
        }
        MemberbacksProject other = (MemberbacksProject) object;
        if ((this.memberbacksProjectPK == null && other.memberbacksProjectPK != null) || (this.memberbacksProjectPK != null && !this.memberbacksProjectPK.equals(other.memberbacksProjectPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dac2014equipe3.sujet2.model.entity.MemberbacksProject[ memberbacksProjectPK=" + memberbacksProjectPK + " ]";
    }

}
