package com.cydeo.tests.day6_AlertsIframesWindows;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Task5_WindowHandle {

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
    public void WindowPractice() {

        //Click "Click Here" for opening a new window

        WebElement clickHere = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();
        clickHere.click();
        clickHere.click();
        clickHere.click();
        clickHere.click();

        //Switch to new window
        String firstWindowHandle = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println(windowHandles);

        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            HandleWait.staticWait(1);
        }

        driver.get("https://google.com");

        driver.switchTo().window(firstWindowHandle);

        clickHere.click();


    }

}
