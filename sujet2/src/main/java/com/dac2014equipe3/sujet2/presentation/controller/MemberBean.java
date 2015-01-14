/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac2014equipe3.sujet2.presentation.controller;

import com.dac2014equipe3.sujet2.businesslogic.facade.FacadeFactory;
import com.dac2014equipe3.sujet2.businesslogic.facade.MemberFacade;
import com.dac2014equipe3.sujet2.businesslogic.facade.MemberbacksProjectFacade;
import com.dac2014equipe3.sujet2.businesslogic.facade.MembercreatesProjectFacade;
import com.dac2014equipe3.sujet2.model.entity.Project;
import com.dac2014equipe3.sujet2.util.Utilities;
import com.dac2014equipe3.sujet2.vo.MemberVo;
import com.dac2014equipe3.sujet2.vo.MembercreatesProjectVo;
import com.dac2014equipe3.sujet2.vo.ProjectVo;
import org.apache.commons.lang.StringUtils;
import org.primefaces.context.RequestContext;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Jummartinezro
 */

@ManagedBean(name = "memberBean")
@SessionScoped
public class MemberBean {

    private int id;
    private boolean loggedIn;
    private boolean isAdmin;
    private boolean isSuppressed;
    private String email;
    private String login;
    private String password;
    private String oldPassword;
    private String passwordBis;
    private String lastName;
    private String firstName;
    private String nationality;
    private String sex;
    private String profession;
    private Date birthday;
    private Date joiningDate;
    private List<ProjectVo> createdProjectList;
    private List<ProjectVo> investedProjectList;

    /**********************REGEX FORMULAIRE**********************************************/
    private static String LOGIN_PATTERN = "^[a-z0-9_-]{3,16}$";
    private static String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static String PASSWORD_PATTERN = "^[a-z0-9_-]{6,18}$";
    private static String FIRSTNAME_PATTERN = "^[a-z]+([-][a-zA-Z]+)*";
    private static String LASTNAME_PATTERN = "^[a-z]+([ '-][a-zA-Z]+)*";
    private static String PROFESSION_PATTERN = "^[a-zA-z]+([ '-][a-zA-Z]+)*";

    /******************************* GETTER / SETTER ***********************************/

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the loggedIn
     */
    public boolean isLoggedIn() {
        return loggedIn;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return
     */
    public String getOldPassword() {
        return oldPassword;
    }

    /**
     * @param oldPassword
     */
    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    /**
     * @param loggedIn the loggedIn to set
     */
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return
     */
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * @param isAdmin
     */
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * @return
     */
    public Date getJoiningDate() {
        return joiningDate;
    }

    /**
     * @param joiningDate
     */
    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    /**
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * @param nationality
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * @return
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return
     */
    public String getProfession() {
        return profession;
    }

    /**
     * @param profession
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }

    /**
     * @return
     */
    public boolean isSuppressed() {
        return isSuppressed;
    }

    /**
     * @param isSuppressed
     */
    public void setSuppressed(boolean isSuppressed) {
        this.isSuppressed = isSuppressed;
    }

    /**
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return
     */
    public List<ProjectVo> getInvestedProjectList() {
        return investedProjectList;
    }

    /**
     * @param investedProjectList
     */
    public void setInvestedProjectList(List<ProjectVo> investedProjectList) {
        this.investedProjectList = investedProjectList;
    }

    /**
     * @return
     */
    public List<ProjectVo> getCreatedProjectList() {
        return createdProjectList;
    }

    /**
     * @param createdProjectList
     */
    public void setCreatedProjectList(List<ProjectVo> createdProjectList) {
        this.createdProjectList = createdProjectList;
    }


    /**
     * @return
     */
    public String getPasswordBis() {
        return passwordBis;
    }

    /**
     * @param passwordBis
     */
    public void setPasswordBis(String passwordBis) {
        this.passwordBis = passwordBis;
    }

/**************************************METHODES AJOUTEES******************************/


    /**
     * Recuperer les infos personnelles du membre connecté
     */
    public boolean getDataMember() {
        setId(Utilities.getSessionMemberId());
        setLoggedIn(Utilities.getSessionMemberLoggedIn());

        if (isLoggedIn()) {
            MemberFacade memberFacade = FacadeFactory.getInstance().getMemberFacade();
            setId(getId());
            MemberVo memberVo = memberFacade.find(getId());
            setLogin(memberVo.getMemberLogin());
            setBirthday(memberVo.getMemberBirthday());
            setEmail(memberVo.getMemberEmail());
            setFirstName(memberVo.getMemberFirstname());
            setLastName(memberVo.getMemberLastname());
            setId(memberVo.getMemberId());
            setJoiningDate(memberVo.getMemberJoiningDate());
            setNationality(memberVo.getMemberNationality());
            setSex(memberVo.getMemberSex());
            setProfession(memberVo.getMemberProfession());
            setAdmin(memberVo.getMemberIsAdmin());
            setSuppressed(memberVo.getMemberIsSuppressed());
            setPassword(memberVo.getMemberPassword());
            return true;
        }
        return false;
    }

    /**
     * Mettre à jour les informations de l'utilisateur
     */
    public String updateAccount() {
        setId(Utilities.getSessionMemberId());
        setLoggedIn(Utilities.getSessionMemberLoggedIn());

        if (! isLoggedIn()) {
            Utilities.addMessageToContext(FacesMessage.SEVERITY_ERROR,
                    "Echec de mise à jour, Utilisateur non connecté");
            return "failure";
        } else {
            MemberFacade memberFacade = FacadeFactory.getInstance().getMemberFacade();
            MemberVo memberVo = new MemberVo();
            memberFacade = FacadeFactory.getInstance().getMemberFacade();
            Date datenow = new Date();

            if(!getLogin().matches(LOGIN_PATTERN) ||
                    !getEmail().matches(EMAIL_PATTERN) ||
                    !getPassword().matches(PASSWORD_PATTERN) ||
                    !getSex().contentEquals("F") ||
                    !getSex().contentEquals("M") ||
                    !getFirstName().matches(FIRSTNAME_PATTERN) ||
                    !getLastName().matches(LASTNAME_PATTERN) ||
                    !getBirthday().after(datenow) ||
                    !getProfession().matches(PROFESSION_PATTERN)) {
                Utilities.addMessageToContext(FacesMessage.SEVERITY_ERROR,
                        "Echec de mise à jour (validation des champs)");
                return "failure";
            }

            //TODO Nationalité à checker
            memberVo.setMemberId(getId());
            memberVo.setMemberLogin(getLogin());
            memberVo.setMemberEmail(getEmail());
            memberVo.setMemberPassword(getPassword());
            memberVo.setMemberNationality(getNationality());
            memberVo.setMemberBirthday(getBirthday());
            memberVo.setMemberFirstname(StringUtils.capitalize(getFirstName()));
            memberVo.setMemberLastname(StringUtils.capitalize(getLastName()));
            memberVo.setMemberProfession(StringUtils.capitalize(getProfession()));
            memberVo.setMemberJoiningDate(new Date());
            memberVo.setMemberSex(getSex());
            memberVo.setMemberIsSuppressed(isSuppressed());
            memberVo.setMemberIsAdmin(isAdmin());

            if (memberFacade.updateMember(memberVo)) {
                Utilities.addMessageToContext(FacesMessage.SEVERITY_INFO, " Mis à jour effectué avec succès ") ;
                return "success";
            }
            Utilities.addMessageToContext(FacesMessage.SEVERITY_ERROR, " Echec de mise à jour  ");
            return "failure";
        }
    }

    /**
     * Mettre à jour le mot de passe de l'utilisateur
     */
    public String updatePassword() {
        setId(Utilities.getSessionMemberId());
        setLoggedIn(Utilities.getSessionMemberLoggedIn());

        if (!isLoggedIn()) {
            Utilities.addMessageToContext(FacesMessage.SEVERITY_ERROR,
                    "Echec de mise à jour, Utilisateur non connecté");
            return "failure";
        } else {
            MemberFacade memberFacade = FacadeFactory.getInstance().getMemberFacade();
            MemberVo memberVo =memberFacade.find(getId());

            if (verifyPassword(memberVo.getMemberPassword(), getOldPassword()) && verifyPasswordBisForm(getPasswordBis(),getPassword())) {
                memberVo.setMemberPassword(getPassword());
                memberFacade = FacadeFactory.getInstance().getMemberFacade();
                if (memberFacade.updateMember(memberVo)) {
                    Utilities.addMessageToContext(FacesMessage.SEVERITY_INFO,
                            "Mot de passe mis à jour effectué avec succès ") ;
                    return "success";
                }
                Utilities.addMessageToContext(FacesMessage.SEVERITY_ERROR,
                        "Echec de mis à jour du mot de passe ") ;
                return "failure";
            } else {
                Utilities.addMessageToContext(FacesMessage.SEVERITY_ERROR,
                        "Echec de mis à jour du mot de passe ") ;
                return "failure";
            }
        }
    }

    /**
     * @param dbPassword
     * @param oldPassword
     * @return
     */
    public boolean verifyPassword( String dbPassword , String oldPassword) {
        if (dbPassword.equals(oldPassword))
            return true;
        return false;
    }

    /**
     * Verification du mot de passe bis du formulaire
     * @param password
     * @param passwordBis
     * @return
     */
    public boolean verifyPasswordBisForm( String password , String passwordBis) {

        if (getPasswordBis().equals(getPassword())) {
                return true;
        }
        return false;
    }

    /**
     * Supprimer compte membre
     *
     * @return
     */
    public String deleteAccount() {
        setId(Utilities.getSessionMemberId());
        setLoggedIn(Utilities.getSessionMemberLoggedIn());
        if (!isLoggedIn()) {
            Utilities.addMessageToContext(FacesMessage.SEVERITY_ERROR,
                    "Echec de mise à jour, Utilisateur non connecté");
            return "failure";
        } else {
            MemberFacade memberFacade = FacadeFactory.getInstance().getMemberFacade();
            MemberVo memberVo = memberFacade.find(getId());
            MembercreatesProjectFacade membercreatesProjectFacade = FacadeFactory.getInstance()
                    .getMembercreatesProjectFacade();

            List<ProjectVo> listMemberProjects = membercreatesProjectFacade.getListCreatorProject(getId());
            if (listMemberProjects.size() > 0) {
                Utilities.addMessageToContext(FacesMessage.SEVERITY_ERROR, " Impossible de supprimer le compte" +
                        " Veuillez contacter l'adminnistrateur : admin@dac.imag ") ;
                return "failure";
            }
            memberVo.setMemberIsSuppressed(true);
            memberFacade = FacadeFactory.getInstance().getMemberFacade();
            memberFacade.updateMember(memberVo);
            Utilities.addMessageToContext(FacesMessage.SEVERITY_INFO, " Compte supprimé avec succès ") ;
            //deconnexion
            disconnect();
            return "success";
        }
    }

    /**
     * Deconnecter membre
     *
     * @return
     */
    public String disconnect() {
        setLoggedIn(false);
        Utilities.setSessionMemberLoggedIn(false);
        //TODO supprimer memberBean sinon pb dans la page inscription apres la déconnexion
        return "success";
    }

    /**
     * Convertir le membre en vo
     * @return
     */
    public MemberVo getMemberVo() {
        MemberVo vo = new MemberVo();

        vo.setMemberId(id);
        vo.setMemberEmail(email);
        vo.setMemberLogin(login);
        vo.setMemberPassword(password);
        vo.setMemberIsAdmin(isAdmin);
        vo.setMemberJoiningDate(joiningDate);
        vo.setMemberBirthday(birthday);
        vo.setMemberFirstname(firstName);
        vo.setMemberLastname(lastName);
        vo.setMemberNationality(nationality);
        vo.setMemberSex(sex);
        vo.setMemberProfession(profession);
        vo.setMemberIsSuppressed(isSuppressed);

        return vo;
    }

    /**
     *
     */
    public void getAllMemberProject(){
        MembercreatesProjectFacade membercreatesProjectFacade = FacadeFactory.getInstance()
                .getMembercreatesProjectFacade();
        List<ProjectVo> listMemberProjects = membercreatesProjectFacade.getListCreatorProject(getId());
        setCreatedProjectList(listMemberProjects);
    }

    /**
     *
     */
    public void getAllMemberBackedProject(){
        MemberbacksProjectFacade memberbacksProjectFacade = FacadeFactory.getInstance()
                .getMemberbacksProjectFacade();
        List<ProjectVo> listMemberProjectsBacked = memberbacksProjectFacade.getListProjectBacked(getId());
        setInvestedProjectList(listMemberProjectsBacked);
    }
}
