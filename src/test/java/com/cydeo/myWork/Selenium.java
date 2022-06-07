package com.cydeo.myWork;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Selenium {
    //1. Open browser
    WebDriver driver;
    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//2. Go to website:https://www.amazon.com/
        driver.get("https://www.amazon.com/");
    }
    @Test
    public void amazon_search_selenium() throws InterruptedException {
//3. Write "selenium" in the search box

        WebElement informationAlertButton = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        informationAlertButton.click();

        Thread.sleep(1500);
        informationAlertButton.sendKeys("selenium");

//4-Verify that you see 10 suggestions as dropdown
        List<WebElement> dropdown = driver.findElements(By.xpath("//div[@class ='s-suggestion-container']"));

        Thread.sleep(3000);
        System.out.println("dropdown size = " + dropdown.size());

        for (WebElement each : dropdown) {

            System.out.println(each);


        }

        Assert.assertEquals(dropdown.size(), 10);

//5-Verify that all 10 suggestions contain your search term

        List<WebElement> dropdown2 = driver.findElements(By.xpath("//div[@class ='s-suggestion-container']"));

        Thread.sleep(3000);
        System.out.println("dropdown2.size() = " + dropdown2.size());
        for (WebElement each : dropdown2) {

            String actual = each.getText();
            System.out.println(actual);

            Assert.assertTrue(actual.contains("selenium"));
        }
    }
    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }
}