/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac2014equipe3.sujet2.presentation.controller;

import com.dac2014equipe3.sujet2.businesslogic.facade.FacadeFactory;
import com.dac2014equipe3.sujet2.businesslogic.facade.MemberFacade;
import com.dac2014equipe3.sujet2.model.dao.MemberDAO;
import com.dac2014equipe3.sujet2.model.entity.Member;
import com.dac2014equipe3.sujet2.vo.MemberVo;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author juanmanuelmartinezromero
 */
@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean {

    @ManagedProperty(value = "#{memberBean}")
    private MemberBean user = new MemberBean();
    private String username;
    private String password;
    private MemberDAO memberDAO;

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
     * @return
     */
    public MemberDAO getMemberDAO() {
        return memberDAO;
    }

    /**
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param memberDAO
     */
    public void setMemberDAO(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
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

    /**
     *
     * @return the user connected
     */
    public MemberBean getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(MemberBean user) {
        this.user = user;
    }

    private void openSession(){
        /*HttpSession session = request.getSession();
        String exemple = "abc";
        session.setAttribute( "chaine", exemple );
        String chaine = (String) session.getAttribute( "chaine" );*/
    }

    public String login() {
        MemberVo memberVo = new MemberVo();
        MemberFacade memberFacade = FacadeFactory.getInstance().getMemberFacade();
        memberVo.setMemberLogin(getUsername());
        memberVo.setMemberPassword(getPassword());
        MemberVo login = memberFacade.login(memberVo);

        if (login != null) {
            user.setEmail(login.getMemberEmail());
            user.setId(login.getMemberId());
            user.setLoggedIn(true);

            //TODO Ouvrir session membre
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
