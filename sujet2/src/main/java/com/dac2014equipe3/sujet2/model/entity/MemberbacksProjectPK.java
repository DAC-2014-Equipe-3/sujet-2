/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dac2014equipe3.sujet2.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jummartinezro
 */
@Embeddable
public class MemberbacksProjectPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "backerId")
    private int backerId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "projectId")
    private int projectId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Reward_rewardId")
    private int rewardrewardId;

    public MemberbacksProjectPK() {
    }

    public MemberbacksProjectPK(int backerId, int projectId, int rewardrewardId) {
        this.backerId = backerId;
        this.projectId = projectId;
        this.rewardrewardId = rewardrewardId;
    }

    public int getBackerId() {
        return backerId;
    }

    public void setBackerId(int backerId) {
        this.backerId = backerId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getRewardrewardId() {
        return rewardrewardId;
    }

    public void setRewardrewardId(int rewardrewardId) {
        this.rewardrewardId = rewardrewardId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) backerId;
        hash += (int) projectId;
        hash += (int) rewardrewardId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MemberbacksProjectPK)) {
            return false;
        }
        MemberbacksProjectPK other = (MemberbacksProjectPK) object;
        if (this.backerId != other.backerId) {
            return false;
        }
        if (this.projectId != other.projectId) {
            return false;
        }
        if (this.rewardrewardId != other.rewardrewardId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dac2014equipe3.sujet2.model.entity.MemberbacksProjectPK[ backerId=" + backerId + ", projectId=" + projectId + ", rewardrewardId=" + rewardrewardId + " ]";
    }

}
