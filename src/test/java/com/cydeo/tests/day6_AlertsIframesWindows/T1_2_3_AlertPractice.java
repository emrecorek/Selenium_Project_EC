package com.cydeo.tests.day6_AlertsIframesWindows;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_2_3_AlertPractice {

    WebDriver driver;

    @BeforeMethod
    public void setupBrowser() {

        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }


    @AfterMethod
    public void closeBrowser(){
        HandleWait.staticWait(3);
        //driver.close();
    }

    //TC #1: Information alert practice
    @Test
    public void alertText(){

        //3. Click to “Click for JS Alert” button

        WebElement infoAlertButton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));

        infoAlertButton.click();

        HandleWait.staticWait(3);

        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();



        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement alertText = driver.findElement(By.xpath("//p[@id]"));
        String actualAlertText = alertText.getText();
        String expectedAlertText = "You successfully clicked an alert";

        Assert.assertEquals(actualAlertText, expectedAlertText, "Alert text verification failed");
    }

    @Test
    public void okText(){



    }

    @Test
    public void helloText(){



    }



}

/*
TC #2: Confirmation alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Confirm” button
4. Click to OK button from the alert
5. Verify “You clicked: Ok” text is displayed.
 */