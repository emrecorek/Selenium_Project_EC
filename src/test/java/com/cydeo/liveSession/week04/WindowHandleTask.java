package com.cydeo.liveSession.week04;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandleTask {

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
        //driver.quit();
    }

    //switch to other window method
    public void switchWindow(WebDriver driver){
        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println(windowHandles);

        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }
    }

    @Test
    public void valetParking(){

        //Go to https://shino.de/parkcalc/
        driver.get("https://shino.de/parkcalc/");

        String firstWindowHandle = driver.getWindowHandle();

        //set hour
        WebElement entryHour = driver.findElement(By.xpath("//input[@name='StartingTime']"));
        entryHour.clear();
        HandleWait.staticWait(2);
        entryHour.sendKeys("15:45" + Keys.BACK_SPACE+ Keys.BACK_SPACE+ Keys.BACK_SPACE);

        //click entry date section
        WebElement entryDateSection = driver.findElement(By.xpath("(//img[@alt='Pick a date'])[1]"));
        entryDateSection.click();

        //switch to other window
        switchWindow(driver);

        //set today as the entry date
        WebElement today = driver.findElement(By.xpath("//a[.='21']"));
        today.click();

        //switch to first window
        driver.switchTo().window(firstWindowHandle);

        //click leaving date section
        WebElement leavingDateSection = driver.findElement(By.xpath("(//img[@alt='Pick a date'])[2]"));
        leavingDateSection.click();

        //switch to other window
       switchWindow(driver);

        //set tomorrow as the entry date
        WebElement tomorrow = driver.findElement(By.xpath("//a[.='22']"));
        tomorrow.click();

        //switch to first window
        driver.switchTo().window(firstWindowHandle);

        //calculate
        WebElement calculate = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculate.click();

        //verify cost calculation
        WebElement cost = driver.findElement(By.xpath("//b[.='$ 18.00']"));

        String actualCostText = cost.getText();
        String expectedCostText = "$ 18.00";

        Assert.assertEquals(actualCostText,expectedCostText);

    }

}
