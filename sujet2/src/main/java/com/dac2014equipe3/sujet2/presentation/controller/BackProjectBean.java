package com.dac2014equipe3.sujet2.presentation.controller;

import com.dac2014equipe3.sujet2.businesslogic.facade.FacadeFactory;
import com.dac2014equipe3.sujet2.businesslogic.facade.MemberbacksProjectFacade;
import com.dac2014equipe3.sujet2.businesslogic.facade.ProjectFacade;
import com.dac2014equipe3.sujet2.businesslogic.facade.RewardFacade;
import com.dac2014equipe3.sujet2.model.dao.MemberbacksProjectDAO;
import com.dac2014equipe3.sujet2.model.entity.*;
import com.dac2014equipe3.sujet2.util.Utilities;
import com.dac2014equipe3.sujet2.vo.MemberVo;
import com.dac2014equipe3.sujet2.vo.MemberbacksProjectVo;
import com.dac2014equipe3.sujet2.vo.ProjectVo;
import com.dac2014equipe3.sujet2.vo.RewardVo;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by root on 07/01/15.
 */


@ManagedBean(name = "backProjectBean")
@SessionScoped
public class BackProjectBean {

    private int pledgedEuros;
    private Date backingDate;
    private Member member;
    private ProjectVo project;
    private RewardVo reward;
    private Integer rewardId;
    private List<RewardVo> rewardVoList;
    private MemberbacksProjectPK memberbacksProjectPK;

    /******************************* GETTER / SETTER ***********************************/

    public Integer getRewardId() {
        return rewardId;
    }

    public void setRewardId(Integer rewardId) {
        this.rewardId = rewardId;
    }

    public MemberbacksProjectPK getMemberbacksProjectPK() {
        return memberbacksProjectPK;
    }

    public void setMemberbacksProjectPK(MemberbacksProjectPK memberbacksProjectPK) {
        this.memberbacksProjectPK = memberbacksProjectPK;
    }

    public List<RewardVo> getRewardVoList() {
        return rewardVoList;
    }

    public void setRewardVoList(List<RewardVo> rewardVoList) {
        this.rewardVoList = rewardVoList;
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

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public ProjectVo getProject() {
        return project;
    }

    public void setProject(ProjectVo project) {
        this.project = project;
    }

    public RewardVo getReward() {
        return reward;
    }

    public void setReward(RewardVo reward) {
        this.reward = reward;
    }


    /******************************* METHODES AJOUTEES ***********************************/

    /**
     *
     * @return
     */
    public String addMemberBacksProject(){
        MemberVo memberVo = Utilities.getSessionMember();

        if (Utilities.getSessionMemberLoggedIn()){
            MemberbacksProjectFacade memberbacksProjectFacade = FacadeFactory.getInstance()
                    .getMemberbacksProjectFacade();

            MemberbacksProjectVo memberbacksProjectVo = new MemberbacksProjectVo();

            MemberbacksProjectPK memberbacksProjectPK1 = new MemberbacksProjectPK();
            RewardVo reward = new RewardVo();
            reward.setRewardId(getRewardId());
            memberbacksProjectVo.setProject(getProject());
            memberbacksProjectVo.setBackingDate(new Date());
            memberbacksProjectVo.setPledgedEuros(getPledgedEuros());
            memberbacksProjectVo.setReward(reward);
            memberbacksProjectVo.setMember1(memberVo);

            memberbacksProjectPK1.setBackerId(memberVo.getMemberId());
            memberbacksProjectPK1.setProjectId(getProject().getProjectId());
            memberbacksProjectPK1.setRewardrewardId(reward.getRewardId());
            memberbacksProjectVo.setMemberbacksProjectPK(memberbacksProjectPK1);
            //Todo correction d'erreur dans la base de données
          //  if(verifyRewardMinPledge(getRewardId(),getPledgedEuros())) {
                memberbacksProjectFacade.addMemberBacksProject(memberbacksProjectVo);
                Utilities.addMessageToContext(FacesMessage.SEVERITY_INFO,
                        "Félicitations,Vous venez de financer le projet : "+ getProject().getProjectTitle() + "  Merci.");
                return "success" ;
         //   }
          //  return "failure" ;
        }
      else {
            Utilities.addMessageToContext(FacesMessage.SEVERITY_ERROR, "Vous n'êtes pas connecté");
            return "failure" ;
        }

    }

    /**
     *
     */
    public void getAllProjectReward(){
        RewardFacade rewardFacade = FacadeFactory.getInstance().getRewardFacade();
        List<RewardVo> reward = rewardFacade.getListProjectReward(Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idProject")));
        setRewardVoList(reward);
    }

    /**
     *
     */
    public void getDataForBackingProject(){
        ProjectFacade projectFacade = FacadeFactory.getInstance().getProjectFacade();

        ProjectVo projectVo = new ProjectVo();
        projectVo = projectFacade.find(Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idProject")));
        setRewardId(((RewardVo) rewardVoList.get(0)).getRewardId());
        setProject(projectVo);
    }

    /**
     *
     * @param rewardId
     * @param bakingPrice
     * @return
     */
    public boolean verifyRewardMinPledge(Integer rewardId, int bakingPrice){
        boolean verify =false;
        RewardFacade rewardFacade = FacadeFactory.getInstance().getRewardFacade();
        RewardVo rewardVo = rewardFacade.find(rewardId);
        if(bakingPrice >= Integer.parseInt(rewardVo.getRewardMinPrice())){
            verify = true;
        }else {
            verify =false;
            Utilities.addMessageToContext(FacesMessage.SEVERITY_ERROR,"Veuillez choisir une autre récompense. Recompense supérieur à la contribution. Merci");
        }

        return verify;
    }
}
