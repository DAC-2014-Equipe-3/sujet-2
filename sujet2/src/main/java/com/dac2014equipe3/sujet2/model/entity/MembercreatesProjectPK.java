package com.dac2014equipe3.sujet2.model.entity;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class MembercreatesProjectPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "creatorId")
    private int creatorId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "projectId")
    private int projectId;

    public MembercreatesProjectPK() {
    }

    public MembercreatesProjectPK(int creatorId, int projectId) {
        this.creatorId = creatorId;
        this.projectId = projectId;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) creatorId;
        hash += (int) projectId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MembercreatesProjectPK)) {
            return false;
        }
        MembercreatesProjectPK other = (MembercreatesProjectPK) object;
        if (this.creatorId != other.creatorId) {
            return false;
        }
        if (this.projectId != other.projectId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dac2014equipe3.sujet2.model.entity.MembercreatesProjectPK[ creatorId=" + creatorId + ", projectId=" + projectId + " ]";
    }

}
