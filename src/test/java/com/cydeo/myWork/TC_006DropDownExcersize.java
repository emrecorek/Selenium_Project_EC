package com.cydeo.myWork;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_006DropDownExcersize {


    WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void dropdownTest() {

        driver.get("https://practice.cydeo.com/dropdown");

        Select dates = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        dates.selectByVisibleText("1923");

        Select months = new Select(driver.findElement(By.cssSelector("select[id='month']")));
        months.selectByIndex(11);


        Select days = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        days.selectByValue("15");



        Assert.assertEquals(dates.getFirstSelectedOption().getText(),"1923");

        Assert.assertEquals(months.getFirstSelectedOption().getText(),"December");

        Assert.assertEquals(days.getFirstSelectedOption().getText(),"15");
    }

    @AfterClass

    public void shutdown() throws InterruptedException {
        Thread.sleep(2000);
       // driver.close();
    }


}
