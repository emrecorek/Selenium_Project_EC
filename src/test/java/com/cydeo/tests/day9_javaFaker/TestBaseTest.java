package com.cydeo.tests.day9_javaFaker;

import com.cydeo.tests.base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestBaseTest extends TestBase {

    @BeforeMethod

    @Test
    public void test1(){

       driver.get("https://google.com");
        System.out.println(driver.getTitle());

    }

    @Test
    public void test2(){

        driver.get("https://facebook.com");
        System.out.println(driver.getTitle());

    }
}
