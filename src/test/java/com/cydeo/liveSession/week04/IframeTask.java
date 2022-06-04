package com.cydeo.liveSession.week04;

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

public class IframeTask {

    WebDriver driver;

    @BeforeMethod
    public void setupBrowser() {

        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void closeBrowser(){
        HandleWait.staticWait(3);
       // driver.close();
    }


    @Test
    public void iframeTask(){

        //1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        //accept pop up
        driver.findElement(By.xpath("//div[@id='accept-choices']")).click();

        WebElement iframe = driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(iframe);

        WebElement doubleClick = driver.findElement(By.xpath("//p[.='Double-click me to change my text color.']"));

        String expectedText = "Double-click me to change my text color.";
        String actualText = doubleClick.getText();

        Assert.assertEquals(actualText,expectedText);

    }

}