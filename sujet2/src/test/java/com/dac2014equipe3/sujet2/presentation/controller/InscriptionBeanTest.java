package com.dac2014equipe3.sujet2.presentation.controller;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by lepeteil on 14/01/15.
 */
public class InscriptionBeanTest {

    private static InscriptionBean instance;

    @Test
    public void testAddNewMember(){
        //Condition a tester = login inexistant
        String login = "testlogin";
        String password = "123456";
        String email = "test@gmail.com";
        String nationality = "France";
        Date birthday = new Date();
        String firstname = "raphael";
        String lastname = "Jujajo";
        String sex = "M";
        String profession = "Astronaut";

        System.out.println("Add new member");
        instance.setLogin(login);
        instance.setPassword(password);
        instance.setEmail(email);
        instance.setNationality(nationality);
        instance.setBirthday(birthday);
        instance.setFirstName(firstname);
        instance.setLastName(lastname);
        instance.setSex(sex);
        instance.setProfession(profession);

        String expResult = "success";
        String result = instance.addNewMember();
        assertEquals(expResult, result);
    }
}
