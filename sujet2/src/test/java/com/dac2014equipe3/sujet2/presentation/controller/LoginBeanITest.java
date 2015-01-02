/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac2014equipe3.sujet2.presentation.controller;

import com.dac2014equipe3.sujet2.model.dao.MemberDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juanmanuelmartinezromero
 */
public class LoginBeanITest {

    private static LoginBean instance;

    public LoginBeanITest() {
    }

    @BeforeClass
    public static void setUpClass() {
        instance = new LoginBean();
    }

    @AfterClass
    public static void tearDownClass() {
        instance = null;
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

//    /**
//     * Test of getMail method, of class LoginBean.
//     */
//    @Test
//    public void testGetMail() {
//        System.out.println("getMail");
//        LoginBean instance = new LoginBean();
//        String expResult = "";
//        String result = instance.getMail();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPassword method, of class LoginBean.
//     */
//    @Test
//    public void testGetPassword() {
//        System.out.println("getPassword");
//        LoginBean instance = new LoginBean();
//        String expResult = "";
//        String result = instance.getPassword();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getMemberDAO method, of class LoginBean.
//     */
//    @Test
//    public void testGetMemberDAO() {
//        System.out.println("getMemberDAO");
//        LoginBean instance = new LoginBean();
//        MemberDAO expResult = null;
//        MemberDAO result = instance.getMemberDAO();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getUsername method, of class LoginBean.
//     */
//    @Test
//    public void testGetUsername() {
//        System.out.println("getUsername");
//        LoginBean instance = new LoginBean();
//        String expResult = "";
//        String result = instance.getUsername();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setMemberDAO method, of class LoginBean.
//     */
//    @Test
//    public void testSetMemberDAO() {
//        System.out.println("setMemberDAO");
//        MemberDAO memberDAO = null;
//        LoginBean instance = new LoginBean();
//        instance.setMemberDAO(memberDAO);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setUsername method, of class LoginBean.
//     */
//    @Test
//    public void testSetUsername() {
//        System.out.println("setUsername");
//        String username = "";
//        LoginBean instance = new LoginBean();
//        instance.setUsername(username);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setPassword method, of class LoginBean.
//     */
//    @Test
//    public void testSetPassword() {
//        System.out.println("setPassword");
//        String password = "";
//        LoginBean instance = new LoginBean();
//        instance.setPassword(password);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getUser method, of class LoginBean.
//     */
//    @Test
//    public void testGetUser() {
//        System.out.println("getUser");
//        LoginBean instance = new LoginBean();
//        MemberBean expResult = null;
//        MemberBean result = instance.getUser();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setUser method, of class LoginBean.
//     */
//    @Test
//    public void testSetUser() {
//        System.out.println("setUser");
//        MemberBean user = null;
//        LoginBean instance = new LoginBean();
//        instance.setUser(user);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of login method, of class LoginBean.
     */
    @Test
    public void testLogin() {
        System.out.println("login");

        //Valid Login Case
        System.out.println("\tvalid login");
        instance.setUsername("Jmmr");
        instance.setPassword("1234");
        String expResult = "success";
        String result = instance.login();
        assertEquals(expResult, result);

        //Invalid Login Case
        //@TODO fix or see if must work with JSF
//        System.out.println("\tInvalid login");
//        instance.setUsername("IncorrectUser");
//        instance.setPassword("IncorrectPassword");
//        expResult = "failure";
//        result = instance.login();
//        assertEquals(expResult, result);
        // TODO make test when CommunicationsException (or any other exception) ??
    }

}
