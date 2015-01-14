package com.dac2014equipe3.sujet2.presentation.controller;

import com.dac2014equipe3.sujet2.businesslogic.facade.FacadeFactory;
import com.dac2014equipe3.sujet2.businesslogic.facade.MemberFacade;
import com.dac2014equipe3.sujet2.util.Utilities;
import com.dac2014equipe3.sujet2.vo.MemberVo;
import com.dac2014equipe3.sujet2.vo.ProjectVo;
import org.apache.commons.lang.StringUtils;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.Date;
import java.util.List;

/**
 * Created by lepeteil on 14/01/15.
 */
@ManagedBean(name = "inscriptionBean")
@RequestScoped
public class InscriptionBean {

    private String email;
    private String login;
    private String password;
    private String lastName;
    private String firstName;
    private String nationality;
    private String sex;
    private String profession;
    private Date birthday;

    /**********************REGEX FORMULAIRE**********************************************/
    private static String LOGIN_PATTERN = "^[a-z0-9_-]{3,16}$";
    private static String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static String PASSWORD_PATTERN = "^[a-z0-9_-]{6,18}$";
    private static String FIRSTNAME_PATTERN = "^[a-z]+([-][a-zA-Z]+)*";
    private static String LASTNAME_PATTERN = "^[a-z]+([ '-][a-zA-Z]+)*";
    private static String PROFESSION_PATTERN = "^[a-zA-z]+([ '-][a-zA-Z]+)*";

    /******************************* GETTER / SETTER ***********************************/

    public InscriptionBean() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**************************************METHODES AJOUTEES******************************/

    /**
     * Cree un nouveau membre
     */
    public String addNewMember() {
        //TODO Ouvrir session membre ?

        MemberVo memberVo = new MemberVo();
        MemberFacade memberFacade = FacadeFactory.getInstance().getMemberFacade();
        Date datenow = new Date();

        if(!getLogin().matches(LOGIN_PATTERN) ||
                !getEmail().matches(EMAIL_PATTERN) ||
                !getPassword().matches(PASSWORD_PATTERN) ||
                (!getSex().contentEquals("F") && !getSex().contentEquals("M")) ||
                !getFirstName().matches(FIRSTNAME_PATTERN) ||
                !getLastName().matches(LASTNAME_PATTERN) ||
                !getBirthday().before(datenow) ||
                !getProfession().matches(PROFESSION_PATTERN)) {
            Utilities.addMessageToContext(FacesMessage.SEVERITY_ERROR,
                    "Echec d'inscription (validation des champs");
            return "failure";
        }

        //Verifie si le login est inexistant
        //TODO : resoudre pb exception Attempting to execute an operation on a closed EntityManager.
        /*if (memberFacade.findMemberByLogin(getLogin())) {
            Utilities.addMessageToContext(FacesMessage.SEVERITY_ERROR,
                    "Echec d'inscription : login existant");
            return "failure";
        }*/

        //TODO Nationalité à checker
        memberVo.setMemberLogin(getLogin());
        memberVo.setMemberPassword(getPassword());
        memberVo.setMemberEmail(getEmail().toLowerCase());
        memberVo.setMemberSex(getSex());
        memberVo.setMemberFirstname(StringUtils.capitalize(getFirstName()));
        memberVo.setMemberLastname(StringUtils.capitalize(getLastName()));
        memberVo.setMemberBirthday(getBirthday());
        memberVo.setMemberProfession(StringUtils.capitalize(getProfession()));
        memberVo.setMemberNationality(getNationality());
        //Par défaut
        memberVo.setMemberJoiningDate(new Date());
        memberVo.setMemberIsAdmin(false);
        memberVo.setMemberIsSuppressed(false);
        //Ajout en base
        memberFacade.addMember(memberVo);
        return "success";
    }


}
