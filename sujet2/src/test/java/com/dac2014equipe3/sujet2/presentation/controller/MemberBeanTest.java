package com.dac2014equipe3.sujet2.presentation.controller;

import com.dac2014equipe3.sujet2.util.Utilities;
import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by lepeteil on 03/01/15.
 */
public class MemberBeanTest {

    private static MemberBean instance;
    private static Utilities  instanceUtil;

    public MemberBeanTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        instance = new MemberBean();
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

    @Test
    public void testgetDataMember() {
        System.out.println("Get Data Member");
        instance.setLoggedIn(true);
        instance.setId(1);
        Boolean expResult = true;
        Boolean result = instance.getDataMember();
        assertEquals(expResult, result);
    }

    @Test
    public void testUpdateMember() {
        System.out.println("Update Member");

        System.out.println("\tValid Update Member");
        instance.setLoggedIn(true);
        instance.setId(1);
        String expResult = "success";
        String result = instance.updateAccount();
        assertEquals(expResult, result);

        System.out.println("\tInValid Update Member (Not connected)");

        instance.setLoggedIn(false);
        instance.setId(1);
        expResult = "failure";
        result = instance.updateAccount();
        assertEquals(expResult, result);
    }

    @Test
    public void testverifyPassword(){
        String dbPassword = "1234";
        String formPassword = "1234";
        System.out.println("Verify Password ");
        System.out.println("\tValid Password compare to Database");
       Boolean expResult = true;
        Boolean result = instance.verifyPassword(dbPassword,formPassword);
        assertEquals(expResult, result);

        System.out.println("\tWrong Password compare to Database");
         dbPassword = "1234";
        formPassword = "abcd";
        expResult = false;
         result = instance.verifyPassword(dbPassword,formPassword);
        assertEquals(expResult, result);
    }

    @Test
    public void testverifyPasswordBisForm(){
        String passwordbis = "1234";
        String formPassword = "1234";
        System.out.println("Verify Password Form ");
        System.out.println("\tValid Password compare to PasswordBis");
        Boolean expResult = true;
        Boolean result = instance.verifyPassword(passwordbis,formPassword);
        assertEquals(expResult, result);

        System.out.println("\tWrong Password compare to Database");
        passwordbis = "1234";
        formPassword = "abcd";
        expResult = false;
        result = instance.verifyPassword(passwordbis,formPassword);
        assertEquals(expResult, result);
    }
}
