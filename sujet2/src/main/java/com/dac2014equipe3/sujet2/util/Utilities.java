package com.dac2014equipe3.sujet2.util;

import com.dac2014equipe3.sujet2.presentation.controller.MemberBean;

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
     *
     * @param logout
     */
    public static void setSessionMemberLoggedIn(Boolean logout){
        FacesContext.getCurrentInstance().getApplication()
                .evaluateExpressionGet(FacesContext.getCurrentInstance(), "#{memberBean}",
                        MemberBean.class).setLoggedIn(logout);
    }

}