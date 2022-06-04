package com.cydeo.tests.day8_Properties;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC1_WebTable {

    WebDriver driver;

    @BeforeMethod
    public void setupBrowser(){

        //Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //1. Go to: https://practice.cydeo.com/web-tables
        driver.get("https://practice.cydeo.com/web-tables");


    }

    /*
    @AfterMethod
    public void quitBrowser(){
        //driver.quit();
    }

     */

    @Test
    public void webTable(){

        //2. Verify Bob’s name is listed as expected. Expected: “Bob Martin”

        WebElement bobsName = driver.findElement(By.xpath("//td[.='Bob Martin']"));
        String actualName = bobsName.getText();
        String expectedName = "Bob Martin";

        Assert.assertEquals(actualName,expectedName);

        //3. Verify Bob Martin’s order date is as expected
        //Expected: 12/31/2021

        WebElement orderDate = driver.findElement(By.xpath("//td[.='Bob Martin']/following-sibling::td[3]"));
        String actualOrderDate = orderDate.getText();
        String expectedOrderDate = "12/31/2021";

        Assert.assertEquals(actualOrderDate,expectedOrderDate);

    }

    @Test
    public void webTable2(){

        System.out.println(WebTableUtils.returnOrderDate(driver,"John Doe"));

        WebTableUtils.orderVerify(driver, "John Doe", "01/08/2021");
    }

    @Test
    public void webTable3(){

        WebTableUtils.getTableGetMail(driver, "2", "Jason");
    }


}

/*
2. Verify Bob’s name is listed as expected.
Expected: “Bob Martin”
 */
