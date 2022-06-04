package com.cydeo.tests.day8_Properties;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T4_ConfigPractice {
//
//    WebDriver driver;
//
//    @BeforeMethod
//    public void setupMethod(){
//        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//
//    }

    @Test
    public void googleSearchTask(){

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        //click accept button
        WebElement acceptCookies = Driver.getDriver().findElement(By.xpath("//div[.='Kabul ediyorum']"));
        acceptCookies.click();

        //write "apple" in search box

        String searchKeyword = ConfigurationReader.getProperty("searchKeyword");
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys(searchKeyword + Keys.ENTER);


        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = searchKeyword.trim() + " - Google'da Ara";

        Assert.assertEquals(actualTitle, expectedTitle);



    }
}
