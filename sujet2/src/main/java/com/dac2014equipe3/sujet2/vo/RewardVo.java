package com.dac2014equipe3.sujet2.vo;

import com.dac2014equipe3.sujet2.model.entity.MemberbacksProject;
import com.dac2014equipe3.sujet2.model.entity.Project;

import java.util.List;

public class RewardVo implements IValueObject {

    private int rewardId;
    private String rewardName;
    private String rewardDescription;
    private String rewardMinPrice;
    private List<MemberbacksProject> memberbacksProjectList;
    private Project project;

    public RewardVo() {
    }

    public RewardVo(Integer rewardId, String rewardName, String rewardDescription, String rewardMinPrice) {
        this.rewardId = rewardId;
        this.rewardName = rewardName;
        this.rewardDescription = rewardDescription;
        this.rewardMinPrice = rewardMinPrice;
        this.memberbacksProjectList = null;
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
}