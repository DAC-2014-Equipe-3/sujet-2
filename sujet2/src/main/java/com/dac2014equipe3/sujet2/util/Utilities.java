package com.dac2014equipe3.sujet2.util;

import com.dac2014equipe3.sujet2.presentation.controller.MemberBean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Created by Monssef on 05/01/15.
 */
public class Utilities {

    public static void addMessageToContext(FacesMessage.Severity severity, String message){
        if(severity == FacesMessage.SEVERITY_INFO)
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, "Info", message));
        else if(severity == FacesMessage.SEVERITY_ERROR)
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, "Error", message));
    }
    public static Integer getSessionMemberId(){
        MemberBean controller = FacesContext.getCurrentInstance().getApplication()
                .evaluateExpressionGet(FacesContext.getCurrentInstance(), "#{memberBean}",
                        MemberBean.class);
        return controller.getId();
    }
    public static boolean getSessionMemberLoggedIn(){
        MemberBean controller = FacesContext.getCurrentInstance().getApplication()
                .evaluateExpressionGet(FacesContext.getCurrentInstance(), "#{memberBean}",
                        MemberBean.class);
        return controller.isLoggedIn();
    }
}
