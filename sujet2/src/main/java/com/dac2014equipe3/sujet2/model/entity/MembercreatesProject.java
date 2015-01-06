/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dac2014equipe3.sujet2.model.entity;

import com.dac2014equipe3.sujet2.vo.MembercreatesProjectVo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jummartinezro, chambon for the copy/paste...
 */
@Entity
@Table(name = "Member_creates_Project", catalog = "sujet2", schema = "")
@NamedQueries({
        @NamedQuery(name = "MembercreatesProject.findAll", query = "SELECT m FROM MembercreatesProject m"),
        @NamedQuery(name = "MembercreatesProject.findByMembercreatesProjectPK", query = "SELECT m FROM MembercreatesProject m WHERE (m.membercreatesProjectPK.creatorId = :creatorId) AND (m.membercreatesProjectPK.projectId = :projectId)"),
        @NamedQuery(name = "MembercreatesProject.findByCreatorId", query = "SELECT m FROM MembercreatesProject m WHERE m.membercreatesProjectPK.creatorId = :creatorId"),
        @NamedQuery(name = "MembercreatesProject.findByProjectId", query = "SELECT m FROM MembercreatesProject m WHERE m.membercreatesProjectPK.projectId = :projectId")})
public class MembercreatesProject implements Serializable, IEntity<MembercreatesProjectVo> {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MembercreatesProjectPK membercreatesProjectPK;
    @JoinColumn(name = "creatorId", referencedColumnName = "memberId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Member member1;
    @JoinColumn(name = "projectId", referencedColumnName = "projectId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Project project;

    public MembercreatesProject() {
    }

    public MembercreatesProject(MembercreatesProjectPK membercreatesProjectPK) {
        this.membercreatesProjectPK = membercreatesProjectPK;
    }

    public MembercreatesProject(int creatorId, int projectId) {
        this.membercreatesProjectPK = new MembercreatesProjectPK(creatorId, projectId);
    }

    public MembercreatesProjectPK getMembercreatesProjectPK() {
        return membercreatesProjectPK;
    }

    public void setMembercreatesProjectPK(MembercreatesProjectPK membercreatesProjectPK) {
        this.membercreatesProjectPK = membercreatesProjectPK;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (membercreatesProjectPK != null ? membercreatesProjectPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MembercreatesProject)) {
            return false;
        }
        MembercreatesProject other = (MembercreatesProject) object;
        if ((this.membercreatesProjectPK == null && other.membercreatesProjectPK != null) || (this.membercreatesProjectPK != null && !this.membercreatesProjectPK.equals(other.membercreatesProjectPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dac2014equipe3.sujet2.model.entity.MembercreatesProject[ membercreatesProjectPK=" + membercreatesProjectPK + " ]";
    }

    @Override
    public MembercreatesProjectVo toVo() {
        MembercreatesProjectVo membercreatesProjectVo = new MembercreatesProjectVo(
                membercreatesProjectPK, member1.toVo(), project.toVo());
        return membercreatesProjectVo;
    }
}
