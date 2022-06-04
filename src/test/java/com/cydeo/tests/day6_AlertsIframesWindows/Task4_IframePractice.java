package com.cydeo.tests.day6_AlertsIframesWindows;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task4_IframePractice {

    WebDriver driver;

    @BeforeMethod
    public void setupBrowser() {

        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //2. Go to website: https://practice.cydeo.com/iframe
        driver.get("https://practice.cydeo.com/iframe");
    }

    @AfterMethod
    public void closeBrowser(){
        HandleWait.staticWait(3);
        //driver.close();
    }

    //@Ignore
    @Test
    public void iframePractice(){

        WebElement element = driver.findElement(By.tagName("iframe"));

       // driver.switchTo().frame(element);
       // driver.switchTo().frame(0);
        driver.switchTo().frame("mce_0_ifr");

        WebElement content = driver.findElement(By.xpath("//p[.='Your content goes here.']"));

        //4. Assert: “Your content goes here.” Text is displayed.
        String actualContent = content.getText();
        String expectedContent = "Your content goes here.";

        Assert.assertEquals(actualContent, expectedContent, "Actual content doesn't match with expected");

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
        driver.switchTo().parentFrame();

        WebElement tinyMCE = driver.findElement(By.xpath("//h3"));
        String actualText = tinyMCE.getText();
        String expectedText = "An iFrame containing the TinyMCE WYSIWYG Editor";

        Assert.assertEquals(actualText, expectedText, "Text doesn't match");

        Assert.assertTrue(driver.findElement(By.xpath("//script")).isDisplayed());
    }





}
