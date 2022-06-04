package com.cydeo.tests.day5_DynamicWebElements;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {

    @Test(priority = 1)
    public void test1(){
        System.out.println("test 1 is running...");

        String actual = "apple";
        String expected = "apple1";


        Assert.assertEquals(actual,expected);
    }


    @Test(priority = 2)
    public void test2(){
        System.out.println("test 2 is running...");

        String actual = "apple";
        String expected = "apple1";

        Assert.assertTrue(actual.equals(expected));

    }



    @AfterMethod
    public void tearDownMethod(){
        System.out.println("After method is running...");
    }

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("Before method is running...");
    }

    @BeforeClass
    public void setupTest(){
        System.out.println("Before class");
    }

    @AfterClass
    public void quitTest(){
        System.out.println("After test");
    }
}
