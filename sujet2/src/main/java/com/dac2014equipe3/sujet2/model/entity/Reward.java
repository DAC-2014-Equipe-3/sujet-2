/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dac2014equipe3.sujet2.model.entity;

import com.dac2014equipe3.sujet2.vo.RewardVo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jummartinezro
 */
@Entity
@Table(name = "Reward", catalog = "sujet2", schema = "")
@NamedQueries({
    @NamedQuery(name = "Reward.findAll", query = "SELECT r FROM Reward r"),
    @NamedQuery(name = "Reward.findByRewardId", query = "SELECT r FROM Reward r WHERE r.rewardId = :rewardId"),
    @NamedQuery(name = "Reward.findByRewardName", query = "SELECT r FROM Reward r WHERE r.rewardName = :rewardName"),
    @NamedQuery(name = "Reward.findByRewardDescription", query = "SELECT r FROM Reward r WHERE r.rewardDescription = :rewardDescription"),
    @NamedQuery(name = "Reward.findByRewardMinPrice", query = "SELECT r FROM Reward r WHERE r.rewardMinPrice = :rewardMinPrice")})
public class Reward implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "rewardId")
    private Integer rewardId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "rewardName")
    private String rewardName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "rewardDescription")
    private String rewardDescription;
    @Size(max = 45)
    @Column(name = "rewardMinPrice")
    private String rewardMinPrice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reward")
    private List<MemberbacksProject> memberbacksProjectList;
    @JoinColumn(name = "Project_projectId", referencedColumnName = "projectId")
    @ManyToOne(optional = false)
    private Project project;

    public Reward() {
    }

    public Reward(Integer rewardId) {
        this.rewardId = rewardId;
    }

    public Reward(Integer rewardId, String rewardName, String rewardDescription, String rewardMinPrice, Project project) {
        this.rewardId = rewardId;
        this.rewardName = rewardName;
        this.rewardDescription = rewardDescription;
        this.rewardMinPrice = rewardMinPrice;
        this.project = project;
    }

    public Reward(RewardVo rewardVo) {
        this.rewardId = rewardVo.getRewardId();
        this.rewardName = rewardVo.getRewardName();
        this.rewardDescription = rewardVo.getRewardDescription();
        this.rewardMinPrice = rewardVo.getRewardMinPrice();
        this.project = rewardVo.getProject();
    }

    public Integer getRewardId() {
        return rewardId;
    }

    public void setRewardId(Integer rewardId) {
        this.rewardId = rewardId;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public String getRewardDescription() {
        return rewardDescription;
    }

    public void setRewardDescription(String rewardDescription) {
        this.rewardDescription = rewardDescription;
    }

    public String getRewardMinPrice() {
        return rewardMinPrice;
    }

    public void setRewardMinPrice(String rewardMinPrice) {
        this.rewardMinPrice = rewardMinPrice;
    }

    public List<MemberbacksProject> getMemberbacksProjectList() {
        return memberbacksProjectList;
    }

    public void setMemberbacksProjectList(List<MemberbacksProject> memberbacksProjectList) {
        this.memberbacksProjectList = memberbacksProjectList;
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
        hash += (rewardId != null ? rewardId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reward)) {
            return false;
        }
        Reward other = (Reward) object;
        if ((this.rewardId == null && other.rewardId != null) || (this.rewardId != null && !this.rewardId.equals(other.rewardId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dac2014equipe3.sujet2.model.entity.Reward[ rewardId=" + rewardId + " ]";
    }

}
