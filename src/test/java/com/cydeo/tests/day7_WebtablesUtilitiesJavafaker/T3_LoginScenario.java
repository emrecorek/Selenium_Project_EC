package com.cydeo.tests.day7_WebtablesUtilitiesJavafaker;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T3_LoginScenario extends TestBase {



    @Test
    public void crm_login_1(){

        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3. Enter valid username
        WebElement userName = driver.findElement(By.xpath("//input[@type=\"text\"]"));
        userName.sendKeys("helpdesk1@cybertekschool.com");

        //4. Enter valid password
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("UserUser");

        //5. Click to `Log In` button
        WebElement loginButton = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        loginButton.click();

        BrowserUtils.verifyTitle(driver, "Portal");

    }

    @Test
    public void crm_login_2(){

        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        CRM_Utilities.crm_login(driver);

        BrowserUtils.verifyTitle(driver, "Portal");


    }

    @Test
    public void crm_login_3(){

        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        CRM_Utilities.crm_login(driver, "Helpdesk2@cybertekschool.com", "UserUser");

        BrowserUtils.verifyTitle(driver, "Portal");


    }

}


