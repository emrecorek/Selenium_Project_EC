package com.cydeo.liveSession.week04;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertTask {

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
    public void alertPractice(){

        //Open https://www.demoblaze.com/index.html
        driver.get("https://www.demoblaze.com/index.html");

        //click Laptops //a[.='Laptops']
        WebElement laptops = driver.findElement(By.xpath("//a[.='Laptops']"));
        laptops.click();

        //click "Sony vaio i5"
        WebElement sonyViaoi5 = driver.findElement(By.xpath("//a[.='Sony vaio i5']"));
        sonyViaoi5.click();

        //click Add to cart
        WebElement addToCart = driver.findElement(By.xpath("//a[.='Add to cart']"));
        addToCart.click();

        //Accept pop up confirmation.
        HandleWait.staticWait(1);
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

}
