/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dac2014equipe3.sujet2.model.entity;

import com.dac2014equipe3.sujet2.vo.MemberVo;
import com.dac2014equipe3.sujet2.vo.MemberbacksProjectVo;
import com.dac2014equipe3.sujet2.vo.ProjectVo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jummartinezro
 */
@Entity
@Table(name = "Project", catalog = "sujet2", schema = "")
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p"),
    @NamedQuery(name = "Project.findByProjectId", query = "SELECT p FROM Project p WHERE p.projectId = :projectId"),
    @NamedQuery(name = "Project.findByProjectTitle", query = "SELECT p FROM Project p " +
            "WHERE p.projectTitle = :projectTitle"),
    @NamedQuery(name = "Project.findByProjectFundingGoal", query = "SELECT p FROM Project p " +
            "WHERE p.projectFundingGoal = :projectFundingGoal"),
    @NamedQuery(name = "Project.findByProjectCreationDate", query = "SELECT p FROM Project p " +
            "WHERE p.projectCreationDate = :projectCreationDate"),
    @NamedQuery(name = "Project.findByProjectEndDate", query = "SELECT p FROM Project p " +
            "WHERE p.projectEndDate = :projectEndDate"),
    @NamedQuery(name = "Project.findByProjectDescription", query = "SELECT p FROM Project p " +
            "WHERE p.projectDescription = :projectDescription"),
    @NamedQuery(name = "Project.findByProjectIsSuppressed", query = "SELECT p FROM Project p " +
            "WHERE p.projectIsSuppressed = :projectIsSuppressed")})

public class Project implements Serializable, IEntity<ProjectVo> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "projectId")
    private Integer projectId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ProjectTitle")
    private String projectTitle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "projectFundingGoal")
    private int projectFundingGoal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "projectCreationDate")
    @Temporal(TemporalType.DATE)
    private Date projectCreationDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "projectEndDate")
    @Temporal(TemporalType.DATE)
    private Date projectEndDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "projectDescription")
    private String projectDescription;
    @Column(name = "projectIsSuppressed")
    private Boolean projectIsSuppressed;
    @ManyToMany(mappedBy = "projectList")
    private List<Member> memberList;
    @JoinColumn(name = "projectCategory", referencedColumnName = "categoryId")
    @ManyToOne(optional = false)
    private ProjectCategory projectCategory;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectprojectId")
    private List<Media> mediaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private List<MemberbacksProject> memberbacksProjectList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "project")
    private Reward reward;

    public Project() {
    }

    public Project(Integer projectId) {
        this.projectId = projectId;
    }

    public Project(Integer projectId, String projectTitle, int projectFundingGoal, Date projectCreationDate,
                   Date projectEndDate, String projectDescription) {
        this.projectId = projectId;
        this.projectTitle = projectTitle;
        this.projectFundingGoal = projectFundingGoal;
        this.projectCreationDate = projectCreationDate;
        this.projectEndDate = projectEndDate;
        this.projectDescription = projectDescription;
    }

    public Project(ProjectVo projectVo){
        this.setMediaList(projectVo.getMediaList());
        this.setMemberList(projectVo.getMemberList());
        this.setMemberbacksProjectList(projectVo.getMemberbacksProjectList());
        this.setProjectCategory(projectVo.getProjectCategory());
        this.setProjectCreationDate(projectVo.getProjectCreationDate());
        this.setProjectDescription(projectVo.getProjectDescription());
        this.setProjectEndDate(projectVo.getProjectEndDate());
        this.setProjectFundingGoal(projectVo.getProjectFundingGoal());
        this.setProjectId(projectVo.getProjectId());
        this.setProjectIsSuppressed(projectVo.getProjectIsSuppressed());
        this.setProjectTitle(projectVo.getProjectTitle());
        this.setReward(projectVo.getReward());
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public int getProjectFundingGoal() {
        return projectFundingGoal;
    }

    public void setProjectFundingGoal(int projectFundingGoal) {
        this.projectFundingGoal = projectFundingGoal;
    }

    public Date getProjectCreationDate() {
        return projectCreationDate;
    }

    public void setProjectCreationDate(Date projectCreationDate) {
        this.projectCreationDate = projectCreationDate;
    }

    public Date getProjectEndDate() {
        return projectEndDate;
    }

    public void setProjectEndDate(Date projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public Boolean getProjectIsSuppressed() {
        return projectIsSuppressed;
    }

    public void setProjectIsSuppressed(Boolean projectIsSuppressed) {
        this.projectIsSuppressed = projectIsSuppressed;
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    public ProjectCategory getProjectCategory() {
        return projectCategory;
    }

    public void setProjectCategory(ProjectCategory projectCategory) {
        this.projectCategory = projectCategory;
    }

    public List<Media> getMediaList() {
        return mediaList;
    }

    public void setMediaList(List<Media> mediaList) {
        this.mediaList = mediaList;
    }

    public List<MemberbacksProject> getMemberbacksProjectList() {
        return memberbacksProjectList;
    }

    public void setMemberbacksProjectList(List<MemberbacksProject> memberbacksProjectList) {
        this.memberbacksProjectList = memberbacksProjectList;
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
        hash += (projectId != null ? projectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.projectId == null && other.projectId != null) ||
                (this.projectId != null && !this.projectId.equals(other.projectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dac2014equipe3.sujet2.model.entity.Project[ projectId=" + projectId + " ]";
    }

    @Override
    public ProjectVo toVo() {
        ProjectVo vo = new ProjectVo();

        vo.setMediaList(mediaList);
        vo.setMemberList(memberList);
        vo.setMemberbacksProjectList(memberbacksProjectList);
        vo.setProjectCategory(projectCategory);
        vo.setProjectCreationDate(projectCreationDate);
        vo.setProjectDescription(projectDescription);
        vo.setProjectEndDate(projectEndDate);
        vo.setProjectFundingGoal(projectFundingGoal);
        vo.setProjectId(projectId);
        vo.setProjectIsSuppressed(projectIsSuppressed);
        vo.setProjectTitle(projectTitle);
        vo.setReward(reward);

        return vo;
    }
}
