package com.dac2014equipe3.sujet2.presentation.controller;

import com.dac2014equipe3.sujet2.businesslogic.facade.FacadeFactory;
import com.dac2014equipe3.sujet2.businesslogic.facade.RewardFacade;
import com.dac2014equipe3.sujet2.model.entity.MemberbacksProject;
import com.dac2014equipe3.sujet2.model.entity.Project;
import com.dac2014equipe3.sujet2.model.entity.Reward;
import com.dac2014equipe3.sujet2.util.Utilities;
import com.dac2014equipe3.sujet2.vo.ProjectVo;
import com.dac2014equipe3.sujet2.vo.RewardVo;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "rewardBean")
@SessionScoped
public class RewardBean {

    private Integer rewardId;
    private String rewardName;
    private String rewardDescription;
    private String rewardMinPrice;
    private List<RewardVo> rewardList;

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

    public List<RewardVo> getRewardList() {
        return rewardList;
    }

    public void setRewardList(List<RewardVo> rewardList) {
        this.rewardList = rewardList;
    }

    /***********************************METHODES AJOUTEES*********************************/

    public void clearList(){
        this.rewardList = null;
    }

    public boolean isListEmpty(){
        if(this.rewardList == null || this.rewardList.isEmpty())
            return true;
        return false;
    }

    public void addReward() {
        if(this.rewardList == null){
            this.rewardList = new ArrayList<RewardVo>();
        }

        this.rewardList.add(new RewardVo(
                0,
                this.rewardName,
                this.rewardDescription,
                this.rewardMinPrice));

        this.rewardName = "";
        this.rewardDescription = "";
        this.rewardMinPrice = "";
    }

    public void removeReward(RewardVo rewardVo) {
        this.rewardList.remove(rewardVo);
    }

    public String addListReward(ProjectVo projectVo){

        List<Reward> rewards = new ArrayList<Reward>();
        int i = 0;
        for (RewardVo reward : rewardList) {
            rewards.add(new Reward(this.getRewardList().get(i++)));
        }

        Project project = new Project(projectVo);
        project.setReward(rewards);
        for (RewardVo r : this.rewardList) {
            r.setProject(project);
        }

        RewardFacade rewardFacade = FacadeFactory.getInstance().getRewardFacade();
        rewardFacade.addRewardList(rewardList);
        return "success";
    }
}
