/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac2014equipe3.sujet2.presentation.controller;

import com.dac2014equipe3.sujet2.model.dao.MemberDAO;
import com.dac2014equipe3.sujet2.model.entity.Member;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author juanmanuelmartinezromero
 */
@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean {

    private String username;
    private String password;
    @ManagedProperty(value = "#{memberBean}")
    private MemberBean user;
    
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }

    /**
     * @return the username
     */
    public String getMail() {
        return username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String login() {
        Member member = new Member();

        member.setMemberEmail(getMail());
        member.setMemberPassword(getPassword());

        Member login = MemberDAO.login(member);

        if (login != null) {
            user.setEmail(login.getMemberEmail());
            user.setId(login.getMemberId());
            user.setLoggedIn(true);
            return "success";
        } else {        
            FacesContext.getCurrentInstance().addMessage(
                    "loginForm:username", new FacesMessage(
                    "Membre email ou mot de passe incorrects"));
            FacesContext.getCurrentInstance().addMessage(
                    "loginForm:password", new FacesMessage(
                    "Membre email ou mot de passe incorrects"));
            return "failure";
        }
    }
    
}
