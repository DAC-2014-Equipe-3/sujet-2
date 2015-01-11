package com.dac2014equipe3.sujet2.vo;

import com.dac2014equipe3.sujet2.model.entity.*;
import java.util.Date;
import java.util.List;

public class ProjectVo implements IValueObject{

    private Integer projectId;
    private String projectTitle;
    private int projectFundingGoal;
    private Date projectCreationDate;
    private Date projectEndDate;
    private String projectDescription;
    private boolean projectIsSuppressed;
    private boolean projectIsClosed;
    private List<Member> memberList;
    private ProjectCategory projectCategory;
    private List<Media> mediaList;
    private List<MemberbacksProject> memberbacksProjectList;
    private List<RewardVo> listReward;
    private Integer sumPledge;



    public Integer getSumPledge() {
        return sumPledge;
    }

    public void setSumPledge(Integer sumPledge) {
        this.sumPledge = sumPledge;
    }


    /**
     *
     * @return projectId
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     *
     * @param projectId
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     *
     * @return projectTitle
     */
    public String getProjectTitle() {
        return projectTitle;
    }

    /**
     *
     * @param projectTitle
     */
    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    /**
     *
     * @return projectFundingGoal
     */
    public int getProjectFundingGoal() {
        return projectFundingGoal;
    }

    /**
     *
     * @param projectFundingGoal
     */
    public void setProjectFundingGoal(int projectFundingGoal) {
        this.projectFundingGoal = projectFundingGoal;
    }

    /**
     *
     * @return projectCreationDate
     */
    public Date getProjectCreationDate() {
        return projectCreationDate;
    }

    /**
     *
     * @param projectCreationDate
     */
    public void setProjectCreationDate(Date projectCreationDate) {
        this.projectCreationDate = projectCreationDate;
    }

    /**
     *
     * @return projectEndDate
     */
    public Date getProjectEndDate() {
        return projectEndDate;
    }

    /**
     *
     * @param projectEndDate
     */
    public void setProjectEndDate(Date projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    /**
     *
     * @return projectDescription
     */
    public String getProjectDescription() {
        return projectDescription;
    }

    /**
     *
     * @param projectDescription
     */
    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    /**
     *
     * @return projectIsSuppressed
     */
    public Boolean getProjectIsSuppressed() {
        return projectIsSuppressed;
    }

    /**
     *
     * @param projectIsSuppressed
     */
    public void setProjectIsSuppressed(Boolean projectIsSuppressed) {
        this.projectIsSuppressed = projectIsSuppressed;
    }

    /**
     *
     * @return members
     */
    public List<Member> getMemberList() {
        return memberList;
    }

    /**
     *
     * @param memberList
     */
    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    /**
     *
     * @return projectCategory
     */
    public ProjectCategory getProjectCategory() {
        return projectCategory;
    }

    /**
     *
     * @param projectCategory
     */
    public void setProjectCategory(ProjectCategory projectCategory) {
        this.projectCategory = projectCategory;
    }

    /**
     *
     * @return mediaList
     */
    public List<Media> getMediaList() {
        return mediaList;
    }

    /**
     *
     * @param mediaList
     */
    public void setMediaList(List<Media> mediaList) {
        this.mediaList = mediaList;
    }

    /**
     *
     * @return backers
     */
    public List<MemberbacksProject> getMemberbacksProjectList() {
        return memberbacksProjectList;
    }

    /**
     *
     * @param memberbacksProjectList
     */
    public void setMemberbacksProjectList(List<MemberbacksProject> memberbacksProjectList) {
        this.memberbacksProjectList = memberbacksProjectList;
        setSumPledge(0);
        for (int i = 0, size = memberbacksProjectList.size(); i < size; i++) {
            sumPledge = sumPledge + memberbacksProjectList.get(i).getPledgedEuros();
        }
    }

    public boolean getProjectIsClosed() {
        return projectIsClosed;
    }

    public void setProjectIsClosed(boolean projectIsClosed) {
        this.projectIsClosed = projectIsClosed;
    }

    public List<RewardVo> getListReward() {
        return listReward;
    }

    public void setListReward(List<RewardVo> listReward) {
        this.listReward = listReward;
    }
}
