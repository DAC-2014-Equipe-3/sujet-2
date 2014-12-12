/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dac2014equipe3.sujet2.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jummartinezro
 */
public class Project implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer projectId;
    private String projectTitle;
    private int projectFundingGoal;
    private Date projectCreationDate;
    private Date projectEndDate;
    private String projectDescription;
    private List<Member> member1List;
    private ProjectCategory projectCategory;
    private List<Media> mediaList;
    private List<MemberbacksProject> memberbacksProjectList;
    private Reward reward;

    public Project() {
    }

    public Project(Integer projectId) {
        this.projectId = projectId;
    }

    public Project(Integer projectId, String projectTitle, int projectFundingGoal, Date projectCreationDate, Date projectEndDate, String projectDescription) {
        this.projectId = projectId;
        this.projectTitle = projectTitle;
        this.projectFundingGoal = projectFundingGoal;
        this.projectCreationDate = projectCreationDate;
        this.projectEndDate = projectEndDate;
        this.projectDescription = projectDescription;
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

    public List<Member> getMember1List() {
        return member1List;
    }

    public void setMember1List(List<Member> member1List) {
        this.member1List = member1List;
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
        if ((this.projectId == null && other.projectId != null) || (this.projectId != null && !this.projectId.equals(other.projectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dac2014equipe3.sujet2.model.entity.Project[ projectId=" + projectId + " ]";
    }

}
