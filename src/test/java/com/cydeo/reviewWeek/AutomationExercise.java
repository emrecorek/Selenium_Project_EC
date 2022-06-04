package com.cydeo.reviewWeek;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.HandleWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutomationExercise {

    static WebDriver driver;

    @BeforeMethod
    public void setupBrowser(){

        driver = Driver.getDriver();

        //Navigate to "http://automationexercise.com/"

        driver.get("https://automationexercise.com/");


    }

    @AfterMethod
    public void closeBrowser() {
        HandleWait.staticWait(3);
        //driver.close();
    }

    @Test
    public void TestCase1(){

        //Click signup button
        WebElement signupButton = driver.findElement(By.xpath("//a[.=' Signup / Login']"));
        signupButton.click();

        //Verify 'New User Signup!' is visible
        WebElement newUser = driver.findElement(By.xpath("//h2[.='New User Signup!']"));
        Assert.assertTrue(newUser.isDisplayed());

        //Enter name and email address
        WebElement inputName = driver.findElement(By.xpath("//input[@name='name']"));
        inputName.sendKeys("Monte Kristo");

        WebElement inputEmail = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        inputEmail.sendKeys("montekristo@gmail.com");

        //Click sign up button
        WebElement signupButton2 = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signupButton2.click();

        //Fill details
        driver.findElement(By.xpath("//input[@value='Mr']")).click();

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("montekristo");

        Select Day = new Select(driver.findElement(By.xpath("//select[@id='days']")));
        Select Month = new Select(driver.findElement(By.xpath("//select[@id='months']")));
        Select Year = new Select(driver.findElement(By.xpath("//select[@id='years']")));

        Day.selectByIndex(5);
        Month.selectByVisibleText("March");
        Year.selectByValue("1957");


        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
        driver.findElement(By.xpath("//input[@id='optin']")).click();

        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Monte");

        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Kristo");

        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Cydeo");

        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Layrac");

        new Select(driver.findElement(By.xpath("//select[@id='country']"))).selectByVisibleText("Canada");

        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Toronto");

        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Beril");

        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("47326");

        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("05698765");

        driver.findElement(By.xpath("//button[@type='submit']")).click();





    }


}
