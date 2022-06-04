package com.cydeo.myWork;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class upgenixLogin {

    WebDriver driver;

    @BeforeMethod
    public void setupBrowser(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();



    }

    @Test
    public void loginVerification(){



        for (int i = 5; i < 36 ; i++) {

            driver.get("https://qa.upgenix.net/web/login");
            driver.findElement(By.xpath("//input[@type='text']")).sendKeys("posmanager" + i + "@info.com");
            driver.findElement(By.xpath("//input[@type='password']")).sendKeys("pos.manager" + Keys.ENTER);
            System.out.println(driver.getTitle() + " - " + i);

            HandleWait.staticWait(2);

            //driver.close();

        }



    }


    @AfterMethod
    public void closeBrowser(){

        HandleWait.staticWait(3);
        //driver.close();

    }




}
