package com.dac2014equipe3.sujet2.util;

import com.dac2014equipe3.sujet2.presentation.controller.MemberBean;
import com.dac2014equipe3.sujet2.presentation.controller.RewardBean;
import com.dac2014equipe3.sujet2.vo.MemberVo;
import com.dac2014equipe3.sujet2.vo.ProjectVo;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Created by Monssef on 05/01/15.
 */
public class Utilities {

    /**
     *
     * @param severity
     * @param message
     */
    public static void addMessageToContext(FacesMessage.Severity severity, String message){
        if(severity == FacesMessage.SEVERITY_INFO)
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, "Info", message));
        else if(severity == FacesMessage.SEVERITY_ERROR)
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, "Error", message));
    }

    /**
     *
     * @return
     */
    public static Integer getSessionMemberId(){
        MemberBean controller = FacesContext.getCurrentInstance().getApplication()
                .evaluateExpressionGet(FacesContext.getCurrentInstance(), "#{memberBean}",
                        MemberBean.class);
        return controller.getId();
    }

    /**
     *
     * @return
     */
    public static boolean getSessionMemberLoggedIn(){
        MemberBean controller = FacesContext.getCurrentInstance().getApplication()
                .evaluateExpressionGet(FacesContext.getCurrentInstance(), "#{memberBean}",
                        MemberBean.class);
        return controller.isLoggedIn();
    }

    /**
     * Recuperation de l'objet membre du membre connecté
     * @return
     */
    public static MemberVo getSessionMember(){
        MemberBean controller = FacesContext.getCurrentInstance().getApplication()
                .evaluateExpressionGet(FacesContext.getCurrentInstance(), "#{memberBean}",
                        MemberBean.class);
        return controller.getMemberVo();
    }
    /**
     *
     * @param logout
     */
    public static void setSessionMemberLoggedIn(Boolean logout){
        FacesContext.getCurrentInstance().getApplication()
                .evaluateExpressionGet(FacesContext.getCurrentInstance(), "#{memberBean}",
                        MemberBean.class).setLoggedIn(logout);
    }

    /**
     * Check if the reward list is empty
     * @return
     */
    public static boolean isRewardListEmpty(){
        RewardBean controller = FacesContext.getCurrentInstance().getApplication()
                .evaluateExpressionGet(FacesContext.getCurrentInstance(), "#{rewardBean}",
                        RewardBean.class);
        return controller.isListEmpty();
    }

    /**
     * Persist the reward list saved in the user session
     * @return
     */
    public static String persistRewardList(ProjectVo projectVo){
        RewardBean controller = FacesContext.getCurrentInstance().getApplication()
                .evaluateExpressionGet(FacesContext.getCurrentInstance(), "#{rewardBean}",
                        RewardBean.class);
        return controller.addListReward(projectVo);
    }
}
