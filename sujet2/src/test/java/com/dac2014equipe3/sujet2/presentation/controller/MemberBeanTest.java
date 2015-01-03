package com.dac2014equipe3.sujet2.presentation.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * Created by lepeteil on 03/01/15.
 */
public class MemberBeanTest {

    private static MemberBean instance;

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
}
