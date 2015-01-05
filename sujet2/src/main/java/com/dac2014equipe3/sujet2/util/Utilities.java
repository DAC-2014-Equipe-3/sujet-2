package com.dac2014equipe3.sujet2.util;

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

}
