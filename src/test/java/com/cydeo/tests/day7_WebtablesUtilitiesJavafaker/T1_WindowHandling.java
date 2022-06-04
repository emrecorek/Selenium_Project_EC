package com.cydeo.tests.day7_WebtablesUtilitiesJavafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class T1_WindowHandling {

    WebDriver driver;

    @BeforeMethod
    public void setupBrowser() {

        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //2. Go to website: https://practice.cydeo.com/windows
        driver.get("https://practice.cydeo.com/windows");
    }

    @AfterMethod
    public void closeBrowser() {
        HandleWait.staticWait(3);
        //driver.close();
    }

    @Test
    public void WindowHandle() {

        //Go to : https://www.amazon.com

        driver.get("https://www.amazon.com");

        //3. Copy paste the lines from below into your class
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        HandleWait.staticWait(2);
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        HandleWait.staticWait(2);
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");


        //4. Create a logic to switch to the tab where Etsy.com is open
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String each : allWindowHandles) {

            driver.switchTo().window(each);

            System.out.println("Current url: " + driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains("etsy")) {
                break;
            }


        }

        //5. Assert: Title contains “Etsy”

        String actualTitle = driver.getTitle();
        String expectedTitle = "Etsy";

        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    @Test
    public void WindowHandle2() {

        driver.get("https://www.amazon.com");

        //3. Copy paste the lines from below into your class
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        HandleWait.staticWait(2);
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        HandleWait.staticWait(2);
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        BrowserUtils.switchWindowAndVerify(driver,"facebook", "Facebook");

    }


}
